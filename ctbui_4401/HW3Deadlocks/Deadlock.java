 import java.io.*;
 import java.lang.*;
 import java.util.*;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.ArrayList;  

//main program to run
 public class Deadlock{
	
static int node;
static int resource;
static String action;
static ResourceAllocationGraph rag = new ResourceAllocationGraph("RAG");
static String[] inputArray;
static int inputSize = 0;

	public static void main(String[] args) throws IOException{


		readFile();
		readInput();
		System.out.println("EXECUTION COMPLETED: No deadlock encountered");
				
	}//end of main


static void readFile() throws IOException{

	Scanner input = new Scanner(System.in);
	
	//Asks the user to input the file they want to put in program
	System.out.println("Type the File");

	String textFile = input.nextLine();


	//reads in file
	FileReader fr = new FileReader("input"+textFile+".txt");
	Scanner inFile = new Scanner(fr);

	PrintStream fileStream = new PrintStream("output"+textFile+".txt");
	System.setOut(fileStream);

	String txt = " ";

	while(inFile.hasNext()){

		txt = txt.concat(" "+inFile.nextLine());
	}
	
	//Makes txt into an array 
	inputArray = txt.split("\\s+");

	String temp = "";
	//gets the size of the input array
	try{
                                                                                                           
		while(inputSize > -1){

			inputSize++;
			temp = inputArray[inputSize];

		}

	}catch(ArrayIndexOutOfBoundsException e){
		inputSize--;
	}


}

//this will read the array (aka txt file) and run the program and it's methods with the elements
static void readInput(){

	
	int index = 0;

	//how many lines of code in txt
	int count = inputSize/3;                         

	for(int i = 0; i < count; i++){
 	
 		//first int (Process)
		index++;
		String str = inputArray[index];
		int x = Integer.parseInt(str);
		node = x;

		//Action
		index++;
		action = inputArray[index];

		//second int (Resource)
		index++;
		str = inputArray[index];
		x = Integer.parseInt(str);
		resource = x;

		
		run();


	}
}

static void run(){

	String want = "W";
	String release = "R";

	if(action.equals(want)){

		request(node,resource);

	}else if(action.equals(release)){

		release(node,resource);

	}else{
		
	}

}
static void request(int node, int resource){

	rag.nodeRequest(node,resource);

}

static void release(int node,int resource){

	rag.nodeRelease(node,resource);

}



}//end of class