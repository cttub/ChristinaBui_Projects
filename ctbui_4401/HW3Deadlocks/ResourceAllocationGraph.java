
import java.util.ArrayList;


public class ResourceAllocationGraph{

	private String name;
	private ArrayList<Node> nodeList = new ArrayList<Node>();
	private ArrayList<Resource> resourceList = new ArrayList<Resource>();
	private int nodeIndex;
	private int resourceIndex;
	private boolean deadlock;
	private ArrayList<Integer> deadlockCheckList = new ArrayList<Integer>();
	private int deadlockNodeCheck;

	private int waitingIndex = 0;
	//constructor
	public ResourceAllocationGraph(String x){
		this.name = x;
		this.deadlock = false;
		deadlockCheckList.add(0);
	}

	//adds a node to the list 
	public void addNode(int x){

		Node node = new Node(x);
		nodeList.add(node);
			
	}

	//adds resource to the list 
	public void addResource(int x){

		Resource resource = new Resource(x);
		resourceList.add(resource);
			
	}

	//checks to see if the node is in the list and returns a boolean
	public boolean nodeExist(int x){

		boolean exist = false;

		for(int i = 0; i < nodeList.size(); i++){

			if(nodeList.get(i).getNumber() == x){
				exist = true;
				this.nodeIndex = i;
			}
		}

		return exist;
	}

	//checks to see if the resource is in the list and returns a boolean
	public boolean resourceExist(int x){

		boolean exist = false;

		for(int i = 0; i < resourceList.size();i++){

			if(resourceList.get(i).getNumber() == x){

				exist = true;
				this.resourceIndex = i;
			}
		}

		return exist;
	}


	public void nodeRequest(int node, int resource){

		String print = "Process "+node+" wants resource "+resource;

		//sees if resource is in the list, and gets the index of the resource object
		if(resourceExist(resource) == true){

		}else if(resourceExist(resource) == false){

				addResource(resource);
				this.resourceIndex = resourceList.size()-1;
		}

		//checks to see if node exists, and gets the index of node object
		if(nodeExist(node) == true){

		}else if(nodeExist(node) == false){

				addNode(node);
				this.nodeIndex = nodeList.size()-1;
		}

		int waitingOnNode = -1;

		//checks to see if resource is avaliable
		if(resourceList.get(resourceIndex).isTaken() == true){

			 //if resource is taken, wait on the resource to be released
			//keep track of node's priority
			//keep track of what node holds the resource
			print += " - Process "+node+" must wait";

		
			//gets the node that is holding the resource
			for(int i = 0; i < nodeList.size(); i++){
			//checks if it is holding something first so it does not reach NullPointer
			if(nodeList.get(i).holdingSomething() == true){

					if(nodeList.get(i).isHolding() == resource){

							 waitingOnNode = nodeList.get(i).getNumber();
					}
			}


			}
		
			//gets the priority number for waiting node
			//wait

			int priorityNumber = resourceList.get(resourceIndex).getPriorityNumber(); 

			nodeList.get(nodeIndex).wait(resource,waitingOnNode,priorityNumber);

			//check for deadlock
			checkDeadlock(node);
			

			


		}else if(resourceList.get(resourceIndex).isTaken() == false){

			//if node is not taken, request the resource and change the resource status

			nodeList.get(nodeIndex).request(resourceList.get(resourceIndex));
			resourceList.get(resourceIndex).taken();
			print += " - Resource "+resource+" is now allocated to process "+node;

		}



		System.out.println(print);

	}

	public void nodeRelease(int node,int resource){

	
		int index = -1;
		//finds the node in the list and it's index
		for(int i = 0; i < nodeList.size(); i++){

			if(nodeList.get(i).getNumber() == node){

			    index = i;
			}
		}

		//gets number of resource it held and released the node's data from object
		int releasedResource = nodeList.get(index).isHolding();

		//if statement to check if the resource is the same as what the node is holding
		if(releasedResource == resource){

		nodeList.get(index).release();

		//finds the resource in the list
		for(int i = 0; i < resourceList.size(); i++){

			if(resourceList.get(i).getNumber() == releasedResource){

				index = i;
			}
		}

		//changes the status of resource
		resourceList.get(index).released(); 

		System.out.println("Process "+node+" releases resource "+resourceList.get(index).getNumber()+" - Resource "+resourceList.get(index).getNumber()+" is now free");



		//checks to see if anything is waiting for the resource and then if so, request to the first priority node

		for(int i = 0; i < nodeList.size(); i++){

			if(resourceList.get(index).getNumber() == nodeList.get(i).getWaitResource()){

					nodeList.get(i).decrementPriorityNumber();

					//if priority num is 0 then it's next to allocate resource
					if(nodeList.get(i).getPriorityNumber() == 0){

						//released the node it is already holding
						if(nodeList.get(i).holdingSomething() == true){

							nodeRelease(nodeList.get(i).getNumber(), nodeList.get(i).isHolding());
						}
						nodeRequest(nodeList.get(i).getNumber(), resourceList.get(index).getNumber());
					}
			}
		}

		}else{
			System.out.println("Process "+node+" is not holding Resource "+resource);
		}
	} 

	public void checkDeadlock(int node){

		deadlockNodeCheck = node;

		makeDeadlockCheckList(node);


		//clear the deadlockCheckList Array list so it doesn't add on
		deadlockCheckList.clear();


	}

	public void makeDeadlockCheckList(int node){


		int index = 0;

		//Find where the node is in the list
		for(int i = 0; i < nodeList.size(); i++){

			if(node == nodeList.get(i).getNumber()){
				
				index = i;

			}

		}
			
			//if the node is waiting on something && if the wait node is not the deadlockNodeCheck
			if(nodeList.get(index).isWaiting() == true && nodeList.get(index).getWaitNode() != deadlockNodeCheck){
				
				//add the waitnode to the arrayList int waitnode
				int waitNode = nodeList.get(index).getWaitNode();

				deadlockCheckList.add(waitNode);
				makeDeadlockCheckList(waitNode);

				//determines that there is a deadlock bc it found itself in the array
			}else if(nodeList.get(index).getWaitNode() == deadlockNodeCheck){


				this.deadlock = true;

				ArrayList<Integer> stringNodes = new ArrayList<Integer>();

				String s = "DEADLOCK DETECTED: Processes ";

				//adds the process numbers in the string
				for(int j = 0; j < deadlockCheckList.size(); j++){

					 s += deadlockCheckList.get(j)+",";
					 stringNodes.add(deadlockCheckList.get(j));
				}
					s += deadlockNodeCheck+", and Resources ";
					stringNodes.add(deadlockNodeCheck);


				for(int i = 0; i < stringNodes.size(); i++){

					for(int p = 0; p < nodeList.size(); p++){

						if(stringNodes.get(i) == nodeList.get(p).getNumber()){

							s += nodeList.get(p).getWaitResource()+",";
						}
					}
				}
				System.out.println(s+" are found in a cycle");
				System.exit(0);

			}
			else{

				deadlockCheckList.add(-1);
			}
	}




}//end of class