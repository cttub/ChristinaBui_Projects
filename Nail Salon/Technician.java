public class Technician{


			private String name;
			private int time;
			private Service service;
			private int tips;
			private boolean avaliable;
			private int number;

			//contructor
			public Technician(String name,boolean avaliable){
				this.name = name;
				this.avaliable = avaliable;
			}


	//getters
	public int getTime(){
		return this.time;
	}
	public int getTips(){
		return this.tips;
	}
	public String getName(){
		return this.name;
	}
	public Service getService(){
		return this.service;
	}
	public boolean getStatus(){
		return this.avaliable;
	}
	public int getNumber(){
		return this.number;
	}

	//setters
	public void setName(String name){
		this.name = name;
	}
	public void setTime(int time){
		this.time = time;
	}
	public void setService(Service service){
		this.service = service;
	}
	public void setTips(int tips){
		this.tips = tips;
	}
	public void setStatus(boolean avaliable){
		this.avaliable = avaliable;

	}
	public void setNumber(int number){
		this.number = number;
	}


}//end of class