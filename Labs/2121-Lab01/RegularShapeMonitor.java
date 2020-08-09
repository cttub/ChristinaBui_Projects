import java.util.Observable;
import java.util.Observer;

public class RegularShapeMonitor implements Observer{
	private RegularShape update;

	@Override
	public void update(Observable observable, Object arg1) {
		//#TODO
		update=(RegularShape) observable;
		if(update.getEdgeLength()==0){
			update.calculateArea();
			System.out.println("Warning! Your shape has edges of length 0!");

			System.out.println("New Area: "+update.getArea()); 
		}
		else{
			update.calculateArea();
			System.out.println("Length of edges has changed. Recalculating Area.");
			System.out.println("New Area: "+update.getArea()); 
		}
		//hint, you don't need to do anything with arg1
		
	}

}
