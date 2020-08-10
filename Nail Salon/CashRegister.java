
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
		private Service service;
		private int serviceNumber = 0;
		private int techNumber = 0;
		private int customerNumber = 0;
		


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

				
				listOfServices.remove(i-1);

				for(int j = 0; j < listOfServices.size(); j++){

						listOfServices.get(j).setNumber(j+1);

				}
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

				listOfTechnicians.remove(i-1);

				for(int j = 0; j < listOfTechnicians.size(); j++){

						listOfTechnicians.get(j).setNumber(j+1);

				}
		}



}//end of class