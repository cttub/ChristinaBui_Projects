 import java.io.*;
 import java.lang.*;
 import java.util.*;


//main program to run
 public class DLockTest{
	
static int node;
static int resource;
static char action;
static ResourceAllocationGraph rag = new ResourceAllocationGraph("RAG");


		public static void main(String[] args){

			Scanner input = new Scanner(System.in);
			
			while(input.hasNext()){
				userInput();
				run();

			}

		}//end of main

static void userInput(){

	Scanner input = new Scanner(System.in);


	try{

		node = input.nextInt();

		action = input.next().charAt(0);

		resource = input.nextInt();

	}catch(InputMismatchException e){

		System.out.println("Not Correct Input. Format is: int, string, int");
		userInput();
	}	
	

}

static void run(){


	if(action == 'w' || action == 'W'){

		request(node,resource);

	}else if(action == 'r' || action == 'R'){

		release(node,resource);

	}else{

		System.out.println("Does not regonize action, type input again");
		userInput();
	}

}
static void request(int node, int resource){

	rag.nodeRequest(node,resource);

}

static void release(int node,int resource){

	rag.nodeRelease(node,resource);

}

}//end of class