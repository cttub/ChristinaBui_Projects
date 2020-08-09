public class Triangle extends RegularShape{

	public Triangle(int edgeLength){
		super(3,edgeLength);

	}

	public void calculateArea(){
		double equation;
		double sideLengths;
		equation=Math.sqrt(3)/4;
		sideLengths=getEdgeLength()*getEdgeLength();
		this.area=equation*sideLengths;
	}
	

	
}