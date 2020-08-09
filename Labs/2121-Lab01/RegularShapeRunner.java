import java.util.ArrayList;

public class RegularShapeRunner {

	public static void main(String[] args) {
		
		RegularShape triangle = new Triangle (5);
		RegularShape square = new Square(5);
		ArrayList<RegularShape> shapes = new ArrayList();
		shapes.add(triangle); shapes.add(square);
		
		//Display the properties of all test shapes
		for (RegularShape testRegularShape : shapes) {
			System.out.println(testRegularShape.getAngles());
			System.out.println(testRegularShape.getArea());
		}
		
		/*#TODO*/
		RegularShapeMonitor monitor=new RegularShapeMonitor();//Create a RegularShapeMonitor object
		
		triangle.addObserver(monitor);//add it to all shape objects (triangle and square)
		square.addObserver(monitor);
		
		triangle.setEdgeLength(0);
		square.setEdgeLength(10);

		
		
	}

}
