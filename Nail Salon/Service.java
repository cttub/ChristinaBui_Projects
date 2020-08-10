/*
@author Christina Bui
*/
public class Service{
	
		private int cost;
		private String name;
		private int time;
		private int number;

		//contructor of Item
		public Service(int cost, String name, int time){
				this.cost = cost;
				this.name = name;
				this.time = time;
		}
		//gets the cost of the Service
		public int getCost(){
			return this.cost;
		}
		//gets the name of service
		public String getName(){
			return this.name;
		}
		//gets the time of service
		public int getTime(){
			return this.time;
		}
		//get number
		public int getNumber(){
			return this.number;
		}
		//sets the cost of service
		public void setCost(int cost){
			this.cost = cost;
		}
		//sets the name of service
		public void setName(String name){
			this.name = name;
		}
		//sets the time of service
		public void setTime(int time){
			this.time = time;
		}
		//sets number
		public void setNumber(int number){
			this.number = number;
		}

} //end of class