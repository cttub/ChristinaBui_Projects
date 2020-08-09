/*Christina Bui
	Summa

*/
public class Room{
	private String desc;
	private Room north;
	private Room east;
	private Room west;
	private Room south;
	private String exits;
	

	public Room(String desc){
		this.desc=desc;
		this.north=null;
		this.east=null;
		this.west=null;
		this.south=null;

	}
	public void setNorth(Room north){
		this.north=north;
	}
	public void setEast(Room east){
		this.east=east;
	}
	public void setWest(Room west){
		this.west=west;
	}
	public void setSouth(Room south){
		this.south=south;
	}

	public void setExits(Room n, Room e, Room w, Room s){
		this.north=n;
		this.east=e;
		this.west=w;
		this.south=s;
	}
	public Room getNorth(){
		return this.north;
	}
	public Room getEast(){
		return this.east;
	}
	public Room getWest(){
		return this.west;
	}
	public Room getSouth(){
		return this.south;
	}
	public String getDesc(){
		return this.desc;
	}
	public String getExits(){
		String exits="";
		if(this.north != null){
			String temp = exits + "\nNorth: "+this.north.desc;
			exits=temp;
		}
		if(this.east != null) {
			String temp = exits + "\nEast: "+this.east.desc;
			exits=temp;
		}
		if(this.south != null){
			String temp = exits + "\nSouth: "+this.south.desc;
			exits=temp;
		}

		if(this.west != null){
			String temp = exits + "\nWest: "+this.west.desc;
			exits=temp;
		}

		return exits;
		
	}
	public String toString(){
		return this.desc+"\n"+getExits();
	}

}