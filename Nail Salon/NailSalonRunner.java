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
	System.out.println("1) Make Service\n2) Show Services \n3) Quit");
	int userInput = input.nextInt();

	if(userInput == 1){
		makeService();
		main();
	}
	else if(userInput == 2){
		register.printService();
		main();

	}
	else if(userInput == 3){
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

		Service service = new Service(userInputCost,userInputName);
		register.addService(service);


}//end of makeService()


}//end of class