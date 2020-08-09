//package Lab3Student;
import java.io.IOException;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
//#TODO
//Use appropriate imports
//hint: there are a lot!

public class CartoonCharacterSerializer {
	
	private static ObjectOutputStream outputCartoon;
	private static ObjectInputStream inputCartoon;
	private static PrintWriter writer;
	
	//Method that writes one CartoonCharacter object out to a file
	public static void serializeCharacter(CartoonCharacter character) {
		//#TODO
		try{
		outputCartoon= new ObjectOutputStream(new FileOutputStream("Cartoon.ser"));
		//Initialize outputCartoon to serialize objects to a file called Cartoon.ser
		outputCartoon.writeObject(character);
		//Write the character object out to the 
		outputCartoon.close();
		//Close the stream
	   }
	   catch(IOException e){
	   			e.printStackTrace();
	   }
	}
	
	public static CartoonCharacter deserializeCharacter() {
		CartoonCharacter cartoon = null;
		
		try{
		//#TODO
		inputCartoon=new ObjectInputStream(new FileInputStream("Cartoon.ser"));
		//Initialize inputCartoon to read objects from a file called Cartoon.ser
		cartoon=(CartoonCharacter)inputCartoon.readObject();
		//Read one CartoonCharacter object and store it in variable cartoon
		
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return cartoon;
	}
	
	public static void printToFile(String stringToFile) throws FileNotFoundException {

		//#TODO
		try{	
		writer=new PrintWriter("C-137.txt");
		//Initialize writer to print characters to a file called C-137.txt
		writer.print(stringToFile);
		//Print stringToFile to that file
		writer.print("PrintWriter makes printing 50 times easier!\n");
		//Print the string "PrintWriter makes printing 50 times easier!" followed by a newline character out to the file
		writer.close();
		//Close the PrintWriter stream
	  }
	  	catch(FileNotFoundException e){
	  		e.printStackTrace();
	  	}

	

}
}
