/* Christina Bui
Summa 
Generate all possible UNIQUE combinations of the int 1-100 inclusive, and count them*/
public class Bonus1Hw3

{
	public static void main(String[] args)
	{

 		int person=0;//initialize counter to 0
 	 	int personOne=1;
 	 	int personTwo=2;
 	 	int personThree=3;
 	 	int personFour=4;
 	 	int personFive=5;
 	 	int conversation=0;

 		//for each possible int value for personOne(starting at 1, ending at 100-3)
 			for (personOne=1; personOne<=96; personOne++) {
 		//for each possible int value for personTwo (starting at personOne+1 ending at 100-2)
 				for (personTwo=personOne+1; personTwo<=97; personTwo++) {
 		//for each possible int value for personThree (starting at personTwo+1 ending at 100-1)
 					for (personThree=personTwo+1; personThree<=98; personThree++) {	
 		//for each possible int value for personFour (starting at personThree+1 ending at 100)
 						for (personFour=personThree+1; personFour<=99; personFour++)	{
 							for (personFive=personFour+1; personFive<=100; personFive++) {

 									if (personOne==1)
 									{
 										personOne=1;
 									}
 									else
 										personOne=personOne;

 									if (personTwo==2)
 									{
 										personTwo=2;
 									}	
 									else
 										personTwo=personTwo;

 									if (personThree==3)
 									{
 										personThree=3;
 									}
 									else
 										personThree=personThree;

 									if (personFour==4)
 									{
 										personFour=4;
 									}
 									else
 										personFour=personFour;

 									if (personFive==5)
 									{
 										personFive=5;
 									}
 									else
 										personFive=personFive;



 									conversation=conversation+1;

 									System.out.println(personOne+","+personTwo+","+personThree+","+personFour+","+personFive);
 													}
 												}
 											}
 										}
 									}	
 	

 									System.out.println("There will be "+conversation+ " different conversations");




	}//end of main
}//public class