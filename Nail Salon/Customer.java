import java.io.*;
import java.lang.*;
import java.util.*;
public class Customer{
	
		private String name;
		private List<Service> customerServices = new ArrayList<Service>();
		private int total;

		//customer
		public Customer(String name){
			this.name = name;
		}



		//adds what services customer is getting
		public void addCustomerServices(Service service){
				customerServices.add(service);
		
		}

		//prints out customer services
		public void getCustomerServies(){
				for(int i = 0; i < customerServices.size(); i++){
					System.out.println(customerServices.get(i).getName());
				}
		}

		//calculates/gets total of customer's services
		public int getTotal(){

			for(int i=0; i < customerServices.size(); i++){

					this.total = this.total + customerServices.get(i).getCost();
			}
			return this.total;
		}
}//end of class