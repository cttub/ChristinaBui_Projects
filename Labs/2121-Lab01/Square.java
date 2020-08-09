public class Square extends RegularShape{

	public Square(int edgeLength){
		super(4,edgeLength);
	}

	public void calculateArea(){
		this.area=getEdgeLength()*getEdgeLength();
	}
	
	
}