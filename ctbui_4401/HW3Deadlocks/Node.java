//process
import java.util.ArrayList;

public class Node{
	
	private int number;
	private Resource resource;
	private int waitResourceNumber;
	private int priorityNumber;
	private int waitOnNode;
	private boolean waiting;


	//contructor
	public Node(int x){
		this.number = x;
		this.resource = null;
		this.waiting = false;
	}

	//return number
	public int getNumber(){

		return this.number;
	}


	public void request(Resource resource){

		this.resource = resource;

		this.waitOnNode = 0;
		this.priorityNumber = 1;
		this.waitResourceNumber = 0;
		this.waiting = false;

	}


	public void release(){

		this.resource.released();
		this.resource = null;
	}


	//returns resource that it's holding
	public int isHolding()
	{
		return this.resource.getNumber();
		
	}

	//returns a bool if it is holding something 
	public boolean holdingSomething(){

		boolean x = true;

		if(this.resource == null){

			x = false;

		}

		return x;
	}

	public void wait(int resource, int node, int waitingNumber){

		waitOnNode(node);
		waitForResource(resource);
		setPriorityNumber(waitingNumber);
		this.waiting = true;

	}

	//sets the Node to wait 
	public void waitForResource(int resource){

		this.waitResourceNumber = resource;
	}

	//keeps track of the Node need to wait on
	public void waitOnNode(int node){

		this.waitOnNode = node;
	}

	//sets the priority
	public void setPriorityNumber(int x){

		this.priorityNumber = x;

	}

	//decrements priorityNumber
	public void decrementPriorityNumber(){

		this.priorityNumber--;
	}
	//returns priority number
	public int getPriorityNumber(){

		return this.priorityNumber;
	}

	//gets Node Number it is waiting on
	public int getWaitNode(){

		return this.waitOnNode;
	}

	//gets the resource number it's waiting on
	public int getWaitResource(){

		return this.waitResourceNumber;
	}

	//returns if it's waiting or not
	public boolean isWaiting(){

		return this.waiting;
	}
  	

}//end of class