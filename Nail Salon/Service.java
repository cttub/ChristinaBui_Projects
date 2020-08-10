/*
@author Christina Bui
*/
public class Service{
	
		private int cost;
		private String name;

		//contructor of Item
		public Service(int cost, String name){
				this.cost = cost;
				this.name = name;
		}
		//gets the cost of the Service
		public int getCost(){
			return this.cost;
		}
		//gets the name of service
		public String getName(){
			return this.name;
		}
		//sets the cost of service
		public void setCost(int cost){
			this.cost = cost;
		}
		//sets the name of service
		public void setName(String name){
			this.name = name;
		}

} //end of class