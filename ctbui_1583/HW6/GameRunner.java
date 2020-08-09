import java.util.Scanner;
public class GameRunner{


		static boolean game=true;


		public static void main(String[] args){

			Scanner input=new Scanner(System.in);
				Room balcony=new Room("balcony");
				Room bedroom1=new Room("first bedroom");
				Room bedroom2=new Room("second bedroom");
				Room dining=new Room("dining room");
				Room kitchen=new Room("kitchen");
				Room northHall=new Room("North Hall");
				Room southHall=new Room("South Hall");

			Dungeon dun=new Dungeon(balcony, bedroom1, bedroom2, dining, kitchen, northHall, southHall);

			Room currentRoom=dun.getRoom0();
			Room newRoom=null;
			do{
				System.out.println("\nYou are in "+currentRoom);
				System.out.println("What will you do next?");

				char playerInput=input.next().charAt(0);

				if(playerInput=='n'){
  	 				newRoom=currentRoom.getNorth();
  			
		  	 	}
		  	 	else if(playerInput=='e'){
		  	 		newRoom=currentRoom.getEast();
		  	 
		  			
		  	 	}
		  	 	else if(playerInput=='w'){
		  	 		newRoom=currentRoom.getWest();
		  	 	
		  			
		  	 	}
		  	 	else if(playerInput=='s'){
		  	 		newRoom=currentRoom.getSouth();

		  	 	}
		  	 	else if(playerInput=='q'){
		  	 		game=false;
		  
		  	 	}
		  	 	else{
		  	 		System.out.println("That is not a direction. Please Try Again");
		  	 		
		  	 	}
		  	 	
		  	 	if(newRoom==null && playerInput != 'q'){
		  	 		System.out.println("You hit a dead end pick again");

		  	 	}
		  	 	else{
		  	 		currentRoom=newRoom;
		  	 	}
				
				//userInput varuable



			}while(game==true);

			System.out.println("Thank you for playing the game! See ya");
		}
	
	
}