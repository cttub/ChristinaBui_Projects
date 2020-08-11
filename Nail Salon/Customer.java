import java.io.*;
import java.lang.*;
import java.util.*;
public class Customer{
	
		private String name;
		private List<Service> customerServices = new ArrayList<Service>();
		private int total;
		private int number; 
		private boolean seated;
		private int serviceNumber = 0;
		//customer
		public Customer(String name,boolean seated){
			this.name = name;
			this.seated = seated;
		}



		//adds what services customer is getting
		public void addCustomerServices(Service service){
				serviceNumber++;
				customerServices.add(service);
				service.setNumber(serviceNumber);
				
		
		}

		//prints out customer services
		public void getCustomerServies(){

				for(int i = 0; i < customerServices.size(); i++){

					System.out.println(customerServices.get(i).getNumber()+") "+customerServices.get(i).getName());
				}
		}

		//removes customer service from array
		public void removeCustomerService(int i){
				this.serviceNumber--;

				customerServices.remove(i-1);

				for(int j = 0; j < customerServices.size(); j++){

						customerServices.get(j).setNumber(j+1);

				}
		}

		//gets how long the customer has on their service time
		public int getTime(){
			int time = 0;
				for(int i = 0; i < customerServices.size(); i++){

						time = time+customerServices.get(i).getTime();
				}

				return time;
		}

		//calculates/gets total of customer's services
		public int getTotal(){

			for(int i=0; i < customerServices.size(); i++){

					this.total = this.total + customerServices.get(i).getCost();
			}
			return this.total;
		}

		//set&get for number
		public int getNumber(){
			return this.number;
		}
		public void setNumber(int number){
			this.number = number;

		}
		public void setSeated(boolean seat){
			this.seated = seat;
		}
		public boolean getSeated(){
			return this.seated;
		}
		public String getName(){
			return this.name;
		}
		public void setName(String name){
			this.name = name;
		}	
}//end of class