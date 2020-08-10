
/*
@author Christina Bui

*/
import java.io.*;
import java.lang.*;
import java.util.*;

public class CashRegister{
	
		//array for List of services
		private List<Service> listOfServices = new ArrayList<Service>();
		private Service service;
		


		//add services to array
		public void addService(Service service){

			listOfServices.add(service);

		}

		//prints out list of services
		public void printService(){

			for(int i = 0; i < this.listOfServices.size(); i++){

					System.out.println(this.listOfServices.get(i).getName()+"......."+this.listOfServices.get(i).getTime()+"min.......$"+this.listOfServices.get(i).getCost());
			}
		}



}//end of class