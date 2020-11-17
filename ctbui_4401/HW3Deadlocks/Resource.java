//resource
import java.util.ArrayList;

public class Resource{
	
	private int number;
	private boolean isTaken;	
	private ArrayList<Node> waitingNodes = new ArrayList<Node>();
	private int priorityNumber;

	//contructor
	public Resource(int x){

		this.number = x;
		this.isTaken = false;
		this.priorityNumber = 0;
	}

	//changes status if takem
	public void taken(){

		this.isTaken = true;
	}
	//changes status if released
	public void released(){

		this.isTaken = false;
		if(this.priorityNumber > 0){
			this.priorityNumber =- 1;
		}
	}

	//returns number
	public int getNumber(){

		return this.number;
	}

	public boolean isTaken(){
		return this.isTaken;
	}

	public int getPriorityNumber(){

		this.priorityNumber =+ 1;

		return this.priorityNumber;

	}

}//end of class