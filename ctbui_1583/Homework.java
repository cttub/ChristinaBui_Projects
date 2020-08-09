
import java.util.Scanner;
/*
*Guess your Number!
*Summa
*Program will try to guess the number in User's Head
*@author Christina Bui */
public class Homework
{
public static void main(String[] args)
	{

	int low=0; //Initialize lowest possible to low variable
	int high=100; //Initialize highes possible to high variable
	boolean guess=false; //Initialize Boolean to guess variable
	int userInput; //Initialize User Input
	int initialGuess; //Initialize variable initialGuess
	int attempts=0; //Initialize a variable in which to store number of guesses to attempts
	Scanner input=new Scanner(System.in); //Initialize Scanenr object

	System.out.println("Chose a number 0-100 in your head"); //Prompt User to chose number
	initialGuess=high/2; //Set variable for initialGuess. And store it by taking the high variable and dividing it by two

	
	do
	{ attempts=attempts+1; //Increment attempts in the variable storing number by
	System.out.println("Is your number"+initialGuess+"?"); //Present guess to User with initialGuess
	System.out.println("Type in 1 if Correct. 2 If lower and 3 If higher"); //Present promt to user
	userInput=input.nextInt(); //Use Scanner to grab next int 
	if (userInput==1) 
		{ 
		System.out.println("Your number is"+initialGuess); 
			guess=true;                //If User type 1 CHange boolean variable to true and skip loop and Prompts User with their number
		 }
	else if (userInput==2)
			{
			high=initialGuess-1; //If User types 2 solve for new high Variable by subtracting guess by one
			}
		else if (userInput==3)
			{
			low=initialGuess+1; //If User types 3 solve for new low variable by adding guess by one
			}
	else 
		System.out.println("Error"); //Indicates flaw in User Input
		
       
	initialGuess=high-low; //Subtract Highest Variable by low
	initialGuess=initialGuess/2;     //Take Difference of that and Divide it by 2
	initialGuess=high-initialGuess; //Take Highest variable and subtract from the quotient
	} while (guess==false); //End While loop
	System.out.println("Number of trials is  "+attempts);
  } 



}
