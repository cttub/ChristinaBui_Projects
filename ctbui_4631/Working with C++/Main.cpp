#include "Point2D.h"
#include <iostream>
#include "Rectangle.h"
#include "Triangle.h"
using namespace std;

int main(int argc, char** argv) {

    Point2D* pPoint1 = new Point2D(1.0,2.0);

    //rectangle points
    Point2D  pointOne(4.0,5.0);
    Point2D  pointTwo(4.0,1.0);
    Point2D  pointThree(1.0,1.0);
    Point2D  pointFour(1.0,5.0);

    //triangle points
    Point2D point1(8.0,5.0);
    Point2D point2(10.0,1.0);
    Point2D point3(6.0,1.0);

    //make shape objects
   Rectangle rectangle(pointOne,pointTwo,pointThree,pointFour);
   Triangle triangle(point1,point2,point3);


   	//testing out rectangle
    cout << "Height of Rectangle:" << rectangle.getHeight() << endl;
    cout << "Base of Rectangle:" << rectangle.getBase() << endl;
    cout << "Area of Rectangle:" << rectangle.getArea() << endl;
    cout << "Perimeter of Rectangle:" << rectangle.getPerimeter() << endl;

    cout << "~~~~~~~~~~~~~~~~~" << std::endl;
    
    //testing out triangle
    cout << "Height of Triangle:" << triangle.getHeight() << endl;
    cout << "Base of Triangle:" << triangle.getBase() << endl;
    cout << "Area of Triangle:" << triangle.getArea() << endl;
    cout << "Perimeter of Triangle:" << triangle.getPerimeter() << endl;

    return 0;
}
