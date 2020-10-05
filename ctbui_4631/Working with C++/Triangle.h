#include "Point2D.h"

class Triangle{
	
	
	public:


	//return area of triangle
	double getArea();

	//return perimeter of triangle
	double getPerimeter();

	//return height 
	double getHeight();

	//return base
	double getBase();

	//constructor/deconstructor
	Triangle(Point2D& one, Point2D& two, Point2D& three);
	Triangle(const Triangle& other);
	virtual ~Triangle();

	//Figures out which side is paraellel and returns the length
	double whichIsParallelXAxis();

//instance variables
private:
	double height;
	double base;
	Point2D pointOne;
	Point2D pointTwo;
	Point2D pointThree;
	double area;
	double perimeter;
	Point2D basePoint;
	Point2D topPoint;
};//end of class

