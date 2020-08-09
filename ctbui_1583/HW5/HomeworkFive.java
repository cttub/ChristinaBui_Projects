/* Christina Bui
	Summa
	Adventure Game where the player explores Castle
*/
import java.util.Scanner;
public class HomeworkFive{



/*ROOM BLUEPRINTS
	STRING ARRAY
	0=GlassRoom 
	1=MainLobby
	2=Kitchen
	3=MainHall
	4=GuestRoom
	5=Bathroom
	6=MasterBedRoom
	7=Library


*/
    public static final int NUMBER_OF_ROOMS = 7;
	static String currentLocation="null";
	static boolean game=true;
	static int currentRoom;

	static 	String[] roomDesc={"You are in the Glass Room.\n✿ You can see the landscape all around you.\n✿ The exits are west",
	"You are in the Main Lobby.\n✿ You see maids and servants scatter the room.\n✿ The exits are north, west, and south",
	"You are in the Kitchen.\n✿ Plenty Chefs gladly wave to you while they cook.\n✿ The exits are south",
	"You are in the Main Hall.\n✿ You see several portraits of the kings and queens that lived here.\n✿ The exits are west, south",
	"You are in the Guest Bedroom.\n✿ A mysterious boy is found playing on the bed.\n✿ The exits are south and east",
	"You are in the Bathroom.\n✿ Everything is nice and squeeky clean.\n✿ The exits are east and north",
	"You are in the Master Bedroom.\n✿ The room is elegant and untouched.\n✿ The exits are west, north, and east",
	"You are in the Library.\n✿ There are multiple historical books about the events of the castle.\n✿ The exits are north, and west "};

	static int[][] roomExit={{-1,-1,1,-1},
							  {2,-1,3,7},
							  {-1,-1,-1,1},
							  {-1,1,4,6},
							  {-1,3,-1,5},
							  {4,6,-1,-1},
							  {3,7,5,-1},
							  {1,-1,6,-1}};



	public static void main(String[] args){
		Scanner input=new Scanner(System.in);

	
	
			currentLocation=roomDesc[0];
			currentRoom=0;
			

			do{

				System.out.println("✿ "+currentLocation);
				System.out.print("♡ Where would you like to go next?:");
				playerDirection();
				


			

			}while(game==true);



	


  	 }//end of main

  	 public static void playerDirection(){
  	 	Scanner input=new Scanner(System.in);
  	 	char playerInput=input.nextLine().charAt(0);
  	 	int nextRoom=0;
  	 	if(playerInput=='n'){
  	 		nextRoom=0;
  	 		currentRoom=roomExit[currentRoom][nextRoom];
  			
  	 	}
  	 	else if(playerInput=='e'){
  	 		nextRoom=1;
  	 		currentRoom=roomExit[currentRoom][nextRoom];
  			
  	 	}
  	 	else if(playerInput=='w'){
  	 		nextRoom=2;
  	 		currentRoom=roomExit[currentRoom][nextRoom];
  			
  	 	}
  	 	else if(playerInput=='s'){
  	 		nextRoom=3;
  	 		currentRoom=roomExit[currentRoom][nextRoom];
  	 		

  	 	}
  	 	else if(playerInput=='q'){
  	 		game=false;
  	 		System.out.println("The servants frown and all say: I Guess We Will Have To Find Another Ruler");
  	 	}
  	 	else{
  	 		System.out.println("That is not a direction. Please Try Again");
  	 		playerDirection();
  	 	}
  	 	changeLocation(currentRoom);
  	 }
  	 public static String changeLocation(int currentRoom){

  	 	if(currentRoom== -1){
  	 		System.out.println("!!! That is not an exit. Please Try Again !!!");
  	 		System.out.println("✿ "+currentLocation);
  	 		playerDirection();

  	 	}
  	 	else{
  	 		currentLocation=roomDesc[currentRoom];
  	 	}
  	 	return currentLocation;
  	 }
  	



} //end of class