//Christina Bui
import java.util.*;
import java.util.HashMap;
import java.lang.*;
import java.io.FileReader;
import java.io.IOException;




public class PartA
{
	static int a;
	static long end;
	static long start;
	static long execution;
	static HashMap<String,Integer> hashMap = new HashMap<>();

	public static void main(String[] args) 
	{
		start = System.nanoTime();
		try{
			a = 0;
		execute();
			
		}catch(IOException e){
			
		}

		
	


	}//end of main

static void execute() throws IOException
{
		
		if(a < 99){
			mainProgram();
		}else
			findTopFreq();
}
static void mainProgram() throws IOException
{
		//reads in the file
		FileReader fr = new FileReader("/Users/christinabui/Desktop/ctbui_Assignment2/Part2/bookGuten/guten"+a+".txt");
		Scanner inFile = new Scanner(fr);

		String userInput = "";

		//makes a string based of the file
		while(inFile.hasNext())
		{
			userInput = userInput.concat(" "+inFile.nextLine());
			
		}

		inFile.close();

		//makes the userInput String all lowercase
		userInput = userInput.toLowerCase();


		//Makes userInput into a array by it's words
		String[] words = userInput.split("\\s+");
		//Pulls out any punctuation
		for(int i = 0; i < words.length; i++)
		{
			words[i] = words[i].replaceAll("[^\\w]", "");
		}

	
		//Adds words to hashmap
		addToHashMap(words);
		a++;
		execute();

		//This will determine the top frequencies using the Hashmap

		

		

}//end of method (Main Program)


static void addToHashMap(String[] words){
		
		//String is the Key & Int is Value
		for(int i = 0; i < words.length; i++)
		{
			if(hashMap.containsKey(words[i]))
			{	
				//Gets the current element's freq and increments it
				int freq = hashMap.get(words[i]);
				hashMap.put(words[i], freq+1);
			}else
			 {
			 	//puts array element in hashmap
			 	hashMap.put(words[i],1);
			 }
  
		}
}

static void findTopFreq(){
		//makes a list with the Values of Hashmap
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for(Map.Entry<String,Integer> entry : hashMap.entrySet())
		{
			numbers.add(entry.getValue());
		}



		//puts numbers in descending order
		for(int i = 0; i < numbers.size(); i++)
		{

			int index = 0;
			int bigger = numbers.get(i);

			for(int j = 0; i+j < numbers.size(); j++)
			{
				if(bigger < numbers.get(i+j))
				{
					bigger = numbers.get(i+j);
					 index = i+j;
				}
			}
				
				if(numbers.get(i) != bigger)
				{
				int temp = numbers.get(i);
				numbers.set(i,bigger);
				numbers.set(index,temp);
				}	
		}



		HashMap<String,Integer> highFreq = new HashMap<>();
		
		int wordCount = 0;
		
		for(int i = 0; i < numbers.size();i++)
		{
			
			for(Map.Entry<String,Integer> test : hashMap.entrySet())
			{
				if(numbers.get(i) == test.getValue())
				{	
		
					if(highFreq.containsKey(test.getKey()))
					{

					}else
					 {
					 	highFreq.put(test.getKey(),test.getValue());
					 	System.out.println(test.getKey() +" = "+test.getValue());
					 	wordCount++;

					 	//Stop the program when it shows the top 20
					 	if(wordCount == 20)
					 	{
					 		//increments A and jumps out of mainProgram()
					 	end = System.nanoTime();
						execution = end-start;
						System.out.println("Time: "+execution +" nanoseconds");
						System.exit(0);
					 	
					 	}
					 }		
				}
			} 
		}
}

//this makes an array based on the "Not a vaid book page" to compare to. Returns array
static String[] notABookArray() throws IOException
{

		//reads in the file
		FileReader fr = new FileReader("/Users/christinabui/Desktop/ctbui_Assignment2/Part2/bookGuten/notABook.txt");
		Scanner inFile = new Scanner(fr);

		String userInput = "";

		while(inFile.hasNext())
		{
			userInput = userInput.concat(" "+inFile.nextLine());
			
		}

		inFile.close();

		//makes the userInput String all lowercase
		userInput = userInput.toLowerCase();

		//Makes userInput into a array by it's words
		String[] words = userInput.split("\\s+");
		//Pulls out any punctuation
		for(int i = 0; i < words.length; i++)
		{
			words[i] = words[i].replaceAll("[^\\w]", "");
		}

		return words;

}//end of notABookArray method


//makes file name into an array
static String[] makeFileToArray(String file) throws IOException{
		//reads in the file
		FileReader fr = new FileReader("/Users/christinabui/Desktop/ctbui_Assignment2/Part2/bookGuten/"+file);
		Scanner inFile = new Scanner(fr);

		String userInput = "";

		while(inFile.hasNext())
		{
			userInput = userInput.concat(" "+inFile.nextLine());
			
		}

		inFile.close();

		//makes the userInput String all lowercase
		userInput = userInput.toLowerCase();

		//Makes userInput into a array by it's words
		String[] words = userInput.split("\\s+");
		//Pulls out any punctuation
		for(int i = 0; i < words.length; i++)
		{
			words[i] = words[i].replaceAll("[^\\w]", "");
		}

		return words;
}

//prints out an array
static void printArray(String[] array){

	for(int i = 0; i < array.length; i++){
		System.out.println(array[i]);
	}
}






}//end of class