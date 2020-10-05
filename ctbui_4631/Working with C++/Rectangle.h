#include "Point2D.h"

class Rectangle{
	
	//instances variables
	private:
	double height;
	double base;
	Point2D pointOne;
	Point2D pointTwo;
	Point2D pointThree;
	Point2D pointFour;
	double area;
	double perimeter;


	public:


	//return area of rectangle
	double getArea();

	//return perimeter of rectangle
	double getPerimeter();

	//constructor
	Rectangle(Point2D& one, Point2D& two, Point2D& three, Point2D& four);
	Rectangle(const Rectangle& other);
	virtual ~Rectangle();

	//Figures what side is Parallel from x or y and returns the length of it
	double whichIsParallelXAxis();
	double whichIsParallelYAxis();


	//return height/base
	double getHeight();
	double getBase();



};//end of class