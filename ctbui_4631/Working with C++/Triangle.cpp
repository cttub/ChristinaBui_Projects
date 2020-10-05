#include "Point2D.h"
#include <iostream>
#include "Triangle.h"
#include <math.h>

	
	//constructor
	Triangle::Triangle(Point2D& one, Point2D& two, Point2D& three){
		pointOne = one;
		pointTwo = two;
		pointThree = three;
		basePoint = one;

		

	}
	
	//destructor
	Triangle::~Triangle(){

	}

		//Figures out which side is paraellel and returns the length
		//If Y values are roughly the same.
		double Triangle::whichIsParallelXAxis(){

				if(abs(pointOne.getY() - pointTwo.getY()) <= 0.001 && abs(pointOne.getY() - pointTwo.getY()) >= 0){
						
						//makes basepoint based on finding the base
						basePoint.moveTo(pointOne.getY(),pointThree.getX());
						//makes a top point
						topPoint = pointThree;
						//point one & two's edge are parallel
						return pointOne.distance(pointTwo);

				}else if(abs(pointTwo.getY() - pointThree.getY()) <= 0.001 && abs(pointTwo.getY() - pointThree.getY()) >= 0){

						//makes basepoint based on finding the base
						basePoint.moveTo(pointTwo.getY(),pointOne.getX());
						//makes a top point
						topPoint = pointOne;
						//point two & three's edge are perallel
						return pointTwo.distance(pointThree);

				}else if(abs(pointThree.getY() - pointOne.getY()) <= 0.001 && abs(pointThree.getY() - pointOne.getY()) >= 0){

						//makes basepoint based on finding the base
						basePoint.moveTo(pointThree.getY(),pointTwo.getX());
						//makes a top point
						topPoint = pointTwo;
						//point three & one's edge are perallel
						return pointThree.distance(pointOne);
				}
				return 0;
		}



		//returns the height of triangle
		double Triangle::getHeight(){
			
			whichIsParallelXAxis();
			this->height = topPoint.distance(basePoint);
			return height;
		}

		//returns the base of triangle
		double Triangle::getBase(){
			this->base = whichIsParallelXAxis();
			return base;

		}

		
		//calculates the area of a triangle base don the points
		//Area is height * base / 2
		double Triangle::getArea(){
			this->area = getHeight() * getBase();
			this->area = this->area/2;
			return area;


		}
		//calculates the perimeter of triangle
		//Permeter is side + base + side
		double Triangle::getPerimeter(){
			this->perimeter = pointOne.distance(pointTwo) + pointTwo.distance(pointThree) + pointThree.distance(pointOne);
			return perimeter;

		}



