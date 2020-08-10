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


	System.out.println("What would you want to do?");

	//Change this to add categories regarding task and options
	System.out.println("1) Make Service\n2) Show Services \n4) Remove Service\n5) Quit");
	int userInput = input.nextInt();

	if(userInput == 1){
		makeService();
		main();
	}
	else if(userInput == 2){
		register.printService();
		main();

	}
	else if(userInput == 4){
		//removeService();
		System.out.println("Work in progress");
		main();

	}
	else if(userInput == 5){
		System.out.println("Goodbye!");
	}
	else{
		System.out.println("Not an option");
		main();
	}

	

}//end of main()

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
/*
static void removeService(){
	Scanner input = new Scanner(System.in);
	System.out.println("What service would you like to remove?");
	int userInput = input.nextInt();

	register.removeService(userInput);


}*/

}//end of class