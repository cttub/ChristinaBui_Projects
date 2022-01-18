import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;
import java.io.IOException;

public class ReadFile {

    static ArrayList<String> text = new ArrayList<String>(); //ArrayList Object
    static ArrayList<String> whitelist = new ArrayList<String>(); //ArrayList Object Whitelist

  public static void main(String[] args) {

    //reads in file and adds it to ArrayList
    try {

      File myObj = new File("whitelist.txt");
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {

          String data = myReader.nextLine();
          text.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {

        System.out.println("An error occurred.");
        e.printStackTrace();

    }

    
    removeWhiteSpace();
    removeWhiteSpace();

    addressesOnly(0);
    printArray();

  }//end of main

//removes white space in array
static void removeWhiteSpace(){

 for(int i= 0; i < text.size(); i++){
      
        if(text.get(i).isEmpty() == true){

            text.remove(i);
        }

    }//end of For

}

//prints array 
static void printArray(){

     for(int i= 0; i < whitelist.size(); i++){
      
        System.out.println(whitelist.get(i));

    }//end of For
    int size = whitelist.size()-1;
   System.out.println("Count: "+size);
}

//makes the array to show address only
static void addressesOnly(int index){
    try{

        for(int i= index; i < text.size(); i++){
            index = i;
            if(text.get(i).charAt(0) == '0' && text.get(i).charAt(1) == 'x'){
                 whitelist.add(text.get(i)); 
            }   
           
        }
    }catch(StringIndexOutOfBoundsException e){

            addressesOnly(index+1);

    }
  
}


}//end of class