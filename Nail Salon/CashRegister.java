
/*
@author Christina Bui

This class should: Calculate Customer Services
				   Organize Customer Line/TUrn
				   Estimate the time between Customer
				   Keep track of what technician is avaliable
				   Keep track of Technician Tips
*/
import java.io.*;
import java.lang.*;
import java.util.*;

public class CashRegister{
	
		//array for List of services
		private List<Service> listOfServices = new ArrayList<Service>();
		private Service service;
		private int arrayIndex;
		private int total;


		//add services to array
		public void addService(Service service){

			listOfServices.add(service);
			this.arrayIndex++;

		}
		//gets total of service cost
		public int getTotal(){

			for(int i = 0; i < this.arrayIndex - 1; i++){

					total = total + listOfServices.get(i).getCost(); 

			}

			return total;
		}

		//prints out list of services
		public void printService(){

			for(int i = 0; i < this.listOfServices.size(); i++){

					System.out.println(this.listOfServices.get(i).getName()+".......$"+this.listOfServices.get(i).getCost());
			}
		}

}//end of class