/*Christina Bui
*/
public class Dungeon{
	private Room balcony;
	private Room bedroom1;
	private Room bedroom2;
	private Room dining;
	private Room kitchen;
	private Room northHall;
	private Room southHall;

	public Dungeon(Room balcony,Room bedroom1,Room bedroom2,Room dining,Room kitchen,Room northHall,Room southHall){
			this.balcony=balcony;
			this.bedroom1=bedroom1;
			this.bedroom2=bedroom2;
			this.dining=dining;
			this.kitchen=kitchen;
			this.northHall=northHall;
			this.southHall=southHall;

		
			
			this.balcony.setExits(null, null, null, northHall);
			this.bedroom1.setExits(null,null,northHall,null);
			this.bedroom2.setExits(northHall,null,null,null);
			this.dining.setExits(kitchen,null,null,null);
			this.kitchen.setExits(null,southHall,null,null);
			this.northHall.setExits(balcony,bedroom1,null,bedroom2);
			this.southHall.setExits(null,northHall,kitchen,null);
	}


	public Room getRoom0(){
			return this.balcony;
	}
}