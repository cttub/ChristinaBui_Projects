/*
@author Christina Bui
*/
import java.io.*;
import java.lang.*;
import java.util.*;

public class NailSalonRunner{

		//services for customeres
		static Service service;

		//Organizes Servies and Customer Service
		static CashRegister register = new CashRegister();


		public static void main(String[] args){
		
			main();


		}//end of main

//main taskbar where user chooses what to do
static void main(){
	Scanner input = new Scanner(System.in);


	System.out.println("Main Menu");
	System.out.println("1) Services\n2) Check in/Check out Customer\n3) Technician\n4) Quit");
	int userInput = input.nextInt();

	if(userInput == 1){
		serviceOptions();
	}
	else if(userInput == 2){

	}
	else if(userInput == 3){
		technician();
	}
	else if(userInput == 4){
		System.out.println("Goodbye");
		System.exit(0);
	}
	
	main();
	

}//end of main()
static void serviceOptions(){
	Scanner input = new Scanner(System.in);

System.out.println("Services");
System.out.println("1) Make Service\n2) Show Services \n4) Remove Service\n5) Previous\n6) Quit");

	int userInput = input.nextInt();

	if(userInput == 1){
		makeService();
	
	}
	else if(userInput == 2){
		register.printService();
		

	}
	else if(userInput == 4){
		removeService();
		

	}
	else if(userInput == 5){
		main();
	}
	else if(userInput == 6){
		System.out.println("Goodbye");
		System.exit(0);
	}
	else{
		System.out.println("Not an option");
		
	}

	serviceOptions();


}

//makes service object
static void makeService(){
		Scanner input = new Scanner(System.in);

		System.out.println("Name of Service");
		String userInputName = input.nextLine();
		System.out.println("Cost of Service");
		int userInputCost = input.nextInt();
		System.out.println("Estimate Time for Service");
		int userInputTime = input.nextInt();

		Service service = new Service(userInputCost,userInputName,userInputTime);
		register.addService(service);


}//end of makeService()

static void removeService(){
		Scanner input = new Scanner(System.in);
		register.printService();
		System.out.println("Number of Service to Remove");
		int userInput = input.nextInt();

		register.removeService(userInput);
}

static void technician(){
		Scanner input = new Scanner(System.in);

		System.out.println("Technicians");
		System.out.println("1) Add Technician\n2) Show Technician\n3) Remove Technician \n4) Previous\n5) Quit ");
		int userInput = input.nextInt();

		if(userInput == 1){

				addTechnician();
		}
		else if(userInput == 2){
			register.printTechnician();
		}
		else if(userInput == 3){
			removeTech();
		}
		else if(userInput == 4){
			main();
		}
		else if(userInput == 5){
				System.exit(0);
		}
		else{
			System.out.println("Not an option");

		}

		technician();

}
//adds tech to list
static void addTechnician(){
		Scanner input = new Scanner(System.in);

		System.out.println("Name of Technician");

		String userInput = input.nextLine();

		Technician tech = new Technician(userInput, true);
		register.addTechnician(tech);

}
//remoes tech to list
static  void removeTech(){
		Scanner input = new Scanner(System.in);

		System.out.println("Number of Technician to remove");

		int userInput = input.nextInt();
		register.removeTech(userInput);
}

















}//end of class