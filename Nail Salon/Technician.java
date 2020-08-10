public class Technician{


			private String name;
			private int time;
			private Service service;
			private int tips;
			private boolean avaliable;


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


}//end of class