/*Christina Bui 
A game where the player is given a 
virtual pet to nurture for as long as possible.
Summa */
import java.util.Scanner;
public class VirtualPet{

		static String name;
		static int petAge;
		static int currentHunger;
		static int currentBoredom;
		static int currentDirtiness;
		static int hungerRate;
		static int boredomRate;
		static int dirtinessRate;
		static boolean petRunaway;
		static String hungermessage;
		static String dirtmessage;
		static String boredmessage;
		static String hungerDescription;
		static String dirtDescription;
		static String boredDescription;
		static int playerWrongInput;
		static int petSim;
		static int petFood;
		static int money;
		static String petFoodDesc;
		static String moneyStat;

	public static final int LOW_STAT_THRESHOLD= 3;
	public static final int HIGH_STAT_THRESHOLD= 7;
	public static final int MED_STAT_THRESHOLD= 5;
	public static final int RUNAWAY_STAT_THRESHOLD= 9;

	public static void main(String[] args){

		
		Scanner input=new Scanner(System.in);

		petSim=1;

		while(petSim==1){

		System.out.println("★ Hey YO you gotta a new pet whatchu gonna name it?   ★");
		name=petName();
		currentHunger=0;
		currentBoredom=0;
		currentDirtiness=0;
		hungerRate=1;
		boredomRate=1;
		dirtinessRate=1;
		petAge=0;
		playerWrongInput=0;
		petFood=5;
		money=6;


		

		do {
			System.out.println("♥♡♥♡♥♡♥RISE AND SHINE! "+name+" is still alive! Good job!♥♡♥♡♥♡♥");
			petAge();
			playerInteraction();
			playerPetStatus();
			System.out.println("♥♡♥♡♥♡♥"+name+"'s STATUS♥♡♥♡♥♡♥\n"+playerPetStatus());
			
			

			petRunawayStatus();
		} while (petRunaway==false);


		System.out.println("♡ You had "+name+" for "+petAge+" days ♡");
			playerStatus();


			System.out.print("✿❀ Would you like another pet? ❀✿\n1) Yes!\n2) No\n☆ Enter Here:");
			anotherTry();
			
	}
}




public static String petName(){
		Scanner input=new Scanner(System.in);
		name= input.nextLine();
		return name;
}
public static int anotherTry(){
		Scanner input=new Scanner(System.in);
		int playerTryAgain=input.nextInt();

			if (playerTryAgain==1){
				currentHunger=0;
				currentDirtiness=0;
				currentBoredom=0;
				petSim=1;
			}
			else if (playerTryAgain==2){
				System.out.println("✧○ Thanks for playing ○✧\n ✧･ﾟ:Bye Bye ∠( ᐛ 」∠)＿");
				petSim=2;		
			}
			else if (playerTryAgain!=1 || playerTryAgain!=2){
				System.out.println("NOT AN INPUT!! Please Enter in 1 or 2! (ノTДT)ノ");
				anotherTryWrong();

			}
			return petSim;
		
}
public static int anotherTryWrong(){
		Scanner input=new Scanner(System.in);
		int playerTryAgain=input.nextInt();
			if (playerTryAgain==1){
				currentHunger=0;
				currentDirtiness=0;
				currentBoredom=0;
				petSim=1;
			}
			else if (playerTryAgain==2){
				System.out.println("✧○ Thanks for playing! ○✧\n ✧･ﾟ:Bye Bye ∠( ᐛ 」∠)＿");
				petSim=2;		
			}
			else if (playerTryAgain!=1 || playerTryAgain!=2){
				System.out.println("NOT AN INPUT!! Please Enter in 1 or 2! (ノTДT)ノ");
				anotherTry();

			}
			return petSim;

}

public static int petAge(){
		petAge++;
		System.out.println("           ♥♡♥♡♥♡♥"+name+" is now "+petAge+" years old!♥♡♥♡♥♡♥");
		if (petAge%2==0){
			hungerRate=hungerRate++;
			System.out.println("✖ Hunger rate of "+name+" gets faster! ✖");
			
		}
		else if (petAge%3==0){
			dirtinessRate=dirtinessRate++;
			System.out.println("✖ Yuck! "+name+" gets dirtier faster ✖");
			
		}
		else if (petAge%5==0){
			boredomRate=boredomRate++;
			System.out.println("✖ "+name+" gets bored faster ✖");
			
		}
	
	return petAge;
	

 } //end of PetAge method

static void playerInteraction(){
	Scanner input=new Scanner(System.in); 
	System.out.println("1.)Feed\n2.)Clean\n3.)Play\n4.)Buy Food for "+name+" ($2 for 5 snacks!)\n5.)Work and Leave\n★ What would you like to do with "+name+"? ★");
	int playerInput=input.nextInt();

	if (playerInput==1){
		feedPet();//Call Feed Method
	}
	else if (playerInput==2){
		cleanPet();//Call Clean Method
	}
	else if (playerInput==3){
		playPet();//Call Play Method
	}
	else if (playerInput==4){
		getFood();
	}
	else if (playerInput==5){
		work();
	}
	else if (playerInput!=1 || playerInput!=2 || playerInput!=3 || playerInput!=4 || playerInput!=5){
		playerWrongInput=20;
		System.out.println("A Mysterious Figure Approaches You");
	}

}
static void work(){
	money++;
	currentBoredom=currentBoredom+boredomRate;
	currentDirtiness=currentDirtiness+dirtinessRate;
	System.out.println("● You gained $1!\n"+name+" got a little bored and played outside");

}
static void feedPet(){
	if (petFood>0){
	currentHunger=currentHunger-hungerRate;//Decrease currentHunger by hungerRate
	currentDirtiness=currentDirtiness+dirtinessRate;//Increase currentDirtiness by dirtinessRate
	petFood=petFood-1;
	System.out.println("● "+name+"'s hunger decreased but got a little bit more dirtier");//Display to user what happened
   }
   else if (petFood<=0){
   		System.out.println(" (╬ Ò﹏Ó) You can't feed "+name+"! You need more food! ");
   		playerInteraction();
   }
}
static void cleanPet(){
	currentDirtiness=currentDirtiness-dirtinessRate;//Decrease currentDirtiness by dirtinessRate
	currentBoredom=currentBoredom+boredomRate;//Increase currentBoredom by boredomRate
	System.out.println("● "+name+" pet is cleaner but got more bored with you");
}
static void playPet(){
	currentBoredom=currentBoredom-boredomRate;//Decrease currentBoredom by boredomRate
	currentHunger=currentHunger+hungerRate;//Increase curremtHunger by hungerRate
	System.out.println("● "+name+" pet finds you less boring, but their stomach growls more");
}
static void getFood(){
	if (money>=2){
	currentHunger=currentHunger+hungerRate;
	currentBoredom=currentBoredom+currentBoredom;
	petFood=petFood+5;
	money=money-2;
	System.out.println("● "+name+" crawls into a corner as you leave. "+name+" craves more food and got bored");
	}
	else if(money<2){
		System.out.println("(；￣Д￣)/ Hey. Uh yea. This isn't enough to buy this. Go get more money.");
		playerInteraction();
	}
}
static String playerPetStatus(){
	String status;
	hungerDescription="❁ Hunger Level:";
	petStatusHunger();

	dirtDescription="❁ Cleanliness Level:";
	petStatusDirtiness();

	boredDescription="❁ Boredom Level:";
	petStatusBoredom();

	petFoodDesc="❁ Pet Snacks:"+petFood;

	moneyStat="\n❁ Bank Account:"+money;
	
	
	return status=hungerDescription+petStatusHunger()+dirtDescription+petStatusDirtiness()+boredDescription+petStatusBoredom()+petFoodDesc+moneyStat;
}
		

		public static String petStatusHunger(){
			if (currentHunger<LOW_STAT_THRESHOLD){
				hungermessage=" Very Well!\n";
			}
			else if (currentHunger<MED_STAT_THRESHOLD && currentHunger>LOW_STAT_THRESHOLD){
				hungermessage=" Needs a little more care\n";
			}
			else if (currentHunger<HIGH_STAT_THRESHOLD && currentHunger>MED_STAT_THRESHOLD){
				hungermessage=" Needs some MAJOR assistance before it gets worst\n";
			}
			else {
				hungermessage=" HORRIBLE. What are you doing?\n";
			}
			
			return hungermessage;
		}
		public static String petStatusBoredom(){
				if (currentBoredom<LOW_STAT_THRESHOLD){
				boredmessage=" Very Well!\n";
			}
			else if (currentBoredom<MED_STAT_THRESHOLD && currentBoredom>LOW_STAT_THRESHOLD){
				boredmessage=" Needs a little more care\n";
			}
			else if (currentBoredom<HIGH_STAT_THRESHOLD && currentBoredom>MED_STAT_THRESHOLD){
				boredmessage=" Needs some MAJOR assistance before it gets worst\n";
			}
			else {
				boredmessage=" HORRIBLE. What are you doing?\n";
			}
			
			return boredmessage;
		}
		public static String petStatusDirtiness(){
				if (currentDirtiness<LOW_STAT_THRESHOLD){
				dirtmessage=" Very Well!\n";
			}
			else if (currentDirtiness<MED_STAT_THRESHOLD && currentDirtiness>LOW_STAT_THRESHOLD){
				dirtmessage=" Needs a little more care\n";
			}
			else if (currentDirtiness<HIGH_STAT_THRESHOLD && currentDirtiness>MED_STAT_THRESHOLD){
				dirtmessage=" Needs some MAJOR assistance before it gets worst\n";
			}
			else {
				dirtmessage=" HORRIBLE. What are you doing?\n";
			}
			
			return dirtmessage;
		}
public static boolean petRunawayStatus(){
	if (currentHunger>RUNAWAY_STAT_THRESHOLD){
		System.out.println("✿ "+name+" went to go get their own food ✿");
		petRunaway=true;
	}	
	else if (currentDirtiness>RUNAWAY_STAT_THRESHOLD){
		System.out.println("✿ "+name+" went to a spa near by since you can't clean correctly ✿");
		petRunaway= true;
	}
	else if (currentBoredom>RUNAWAY_STAT_THRESHOLD){
		System.out.println("✿ "+name+" left a note. YOU ARE TOO BORING ✿");
		petRunaway=true;
	}
	else if (playerWrongInput>RUNAWAY_STAT_THRESHOLD){
		System.out.println("✿ THAT WASN'T AN OPTION. Thus I took "+name+" from you. ✿");
		petRunaway=true;
	}
	else{
		petRunaway=false;
	}
		
	return petRunaway;
}
public static int playerStatus(){
	if (petAge<5){
	System.out.println("✧ Maybe the next pet will love you better ✧");
	}
	else if (petAge<15 && petAge>6){
	System.out.println("✧ At least "+name+" cherished you for a little bit ✧");
	}
	else if (petAge>16 && petAge<25){
	System.out.println("✧ "+name+" loved you very much. But not too much ✧");
	}
	else if (petAge>25){
	System.out.println("✧ You are ready to have an official ownership with "+name+" ✧");
	}
	
	return petAge;
} 

}//end of class

