//Christina Bui
import java.util.*;
import java.util.HashMap;
import java.lang.*;
import java.io.FileReader;
import java.io.IOException;

public class PartB
{
	public static void main(String[] args)
	{
		long start = System.nanoTime();
		HashMapObject hashMap = new HashMapObject();

		for(int i = 0; i < 99; i++)
		{
			PartBThread task = new PartBThread(i,hashMap);
			Thread thred = new Thread(task);
			thred.start();

		}

		hashMap.findTopFreq(start);

	}


}//end of class PartB

class PartBThread implements Runnable
{
	private int a;
	private HashMapObject hashMap;
	//constructor
	PartBThread(int a, HashMapObject hashMap)
	{
		this.a = a;
		this.hashMap = hashMap;
	}

	public int getA(){
		return this.a;
	}

	//defining a run method
	public void run()
	{	

		try
		{

		//System.out.println("Thread "+Thread.currentThread().getId()+" is Running");
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

			//adds words array to hashmap
			hashMap.addToHashMap(words);

		}catch(IOException e)
		{

		}
	}

}//end of PartBThreaad class



class HashMapObject
{
	private static HashMap<String,Integer> hashMap = new HashMap<>();
	private static long end;
	private static long execution;

	public HashMap<String,Integer> getHashMap()
	{
		return this.hashMap;
	}
	
	public void addToHashMap(String[] words)
	{

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

	public void findTopFreq(long start)
	{
		
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
	public void printHashMap(){

		for(Map.Entry<String,Integer> entry : hashMap.entrySet()){
				System.out.println(entry.getKey() + " = "+ entry.getValue().toString());
			}
	}

}//end of class HashMapObject