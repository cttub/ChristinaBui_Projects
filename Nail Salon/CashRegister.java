
/*
@author Christina Bui

*/
import java.io.*;
import java.lang.*;
import java.util.*;

public class CashRegister{
	
		//array for List of services
		private List<Service> listOfServices = new ArrayList<Service>();
		private List<Technician> listOfTechnicians = new ArrayList<Technician>();
		private List<Customer> listOfCustomers = new ArrayList<Customer>();
		private Service service;
		private int serviceNumber = 0;
		private int techNumber = 0;
		private int customerNumber = 0;
		private int nextTech = 0;
		


		//add services to array
		public void addService(Service service){
			this.serviceNumber++;
			listOfServices.add(service);
			service.setNumber(serviceNumber);


		}

		//prints out list of services
		public void printService(){

			for(int i = 0; i < this.listOfServices.size(); i++){

					System.out.println(this.listOfServices.get(i).getNumber()+") "+this.listOfServices.get(i).getName()+"......."+this.listOfServices.get(i).getTime()+"min.......$"+this.listOfServices.get(i).getCost());
			}
		}
		//remove services
		public void removeService(int i){

				this.serviceNumber--;

				listOfServices.remove(i-1);

				for(int j = 0; j < listOfServices.size(); j++){

						listOfServices.get(j).setNumber(j+1);

				}
		}

		//gets the service at a certain index
		public Service getService(int i){
				return listOfServices.get(i-1);
		}


		//add technician to list
		public void addTechnician(Technician tech){
			this.techNumber++;
			listOfTechnicians.add(tech);
			tech.setNumber(techNumber);
		}

		//print technician list
		public void printTechnician(){

			for(int i = 0; i < this.listOfTechnicians.size(); i++){

					System.out.println(this.listOfTechnicians.get(i).getNumber()+") "+this.listOfTechnicians.get(i).getName()+".......Avaliability: "+this.listOfTechnicians.get(i).getStatus()+"......Time on Service:"+this.listOfTechnicians.get(i).getTime()+" minutes");
			}
		}

		public void removeTech(int i){

				this.techNumber--;

				listOfTechnicians.remove(i-1);

				for(int j = 0; j < listOfTechnicians.size(); j++){

						listOfTechnicians.get(j).setNumber(j+1);

				}
		}


		//customer methods

		//add customer to list
		public void addCustomer(Customer cust){

			this.customerNumber++;
			listOfCustomers.add(cust);
			cust.setNumber(customerNumber);


		}

		//print Customer list
		public void printCustomerList(){

			 for(int i =0; i < listOfCustomers.size(); i++){

			 		System.out.println(this.listOfCustomers.get(i).getNumber()+") "+this.listOfCustomers.get(i).getName()+"......Seated: "+this.listOfCustomers.get(i).getSeated());
			 }
		}

		//remove customer
		public void removeCustomer(int i){
				this.customerNumber--;

				listOfCustomers.remove(i-1);

				for(int j = 0; j < listOfCustomers.size(); j++){

						listOfCustomers.get(j).setNumber(j+1);

				}
		}


		//checks who the next customer that is not seated; seated = false; Changed the status to true and also changed the status of the Tech that is avaliable = true
		public void nextCustomer(){

				int i = 0;
				

				//go through the list until find someone who is not seated; seated = false
				while(listOfCustomers.get(i).getSeated() != false){

						i++;
				}

				listOfCustomers.get(i).setSeated(true);

				if (this.nextTech > listOfTechnicians.size()) {

						this.nextTech = 0;					
				}

				listOfTechnicians.get(this.nextTech).setStatus(false);
				listOfTechnicians.get(this.nextTech).setTime(listOfCustomers.get(i).getTime());
				this.nextTech++;

		}











}//end of class