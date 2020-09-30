//Christina Bui
import java.util.*;
import java.util.HashMap;
import java.lang.*;
import java.io.FileReader;
import java.io.IOException;

public class PartA
{
	
	public static void main(String[] args) throws IOException
	{

		
		//Calls the user to input what text file they want to use
		System.out.println("Type the File");
		Scanner input = new Scanner(System.in);
		String textFile = input.nextLine();

		//reads in the file
		FileReader fr = new FileReader(textFile);
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

		//creates a hashmap
		//String is the Key & Int is Value
		HashMap<String,Integer> hashMap = new HashMap<>();

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
	
		//This will determine the top frequencies using the Hashmap

		

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
		//prints out word frequencies in decending order (based on top 20)
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
					 		System.exit(0);
					 	}
					 }		
				}
			}
		}

	

	}//end of main
/*
static void printNumbers(){

	System.out.println("Numbers");
		for(int i = 0; i < numbers.size(); i++){
			System.out.println(numbers.get(i));
		}
}

static void printHashMap(){

	System.out.println("Hash Map");
		for(Map.Entry<String,Integer> print : hashMap.entrySet())
		{
			System.out.println(print);
		}
}

static void printHighFreq(){

	System.out.println("High Freq");
		for(Map.Entry<String,Integer> print : highFreq.entrySet())
		{
			System.out.println(print);
		}

}*/

}//end of class