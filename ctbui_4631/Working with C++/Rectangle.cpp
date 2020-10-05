#include "Point2D.h"
#include <iostream>
#include "Rectangle.h"
#include <math.h>

		

		//constructor
		Rectangle::Rectangle(Point2D& one, Point2D& two, Point2D& three, Point2D& four){
			pointOne = one;
			pointTwo = two;
			pointThree = three;
			pointFour = four;
			
		}

		//destuctor
		Rectangle::~Rectangle(){

		}

		//returns the height of rectangle
		double Rectangle::getHeight(){
			this->height = whichIsParallelYAxis();
			return height;
		}

		//returns the base of rectangle
		double Rectangle::getBase(){

			this->base = whichIsParallelXAxis();
			return base;
		}

		//calculates the area of a rectangle base don the points
		//height * base
		double Rectangle::getArea(){
			this->area = getHeight() * getBase();
			return this->area;
		}
		//calculates the perimeter of rectangle
		//2 * (height + base)
		double Rectangle::getPerimeter(){
			this->perimeter = getHeight() + getHeight() + getBase() + getBase();
			return this->perimeter;
		}

	
		//Figures out which side is paraellel and returns the length
		//If Y values are roughly the same.
		double Rectangle::whichIsParallelXAxis(){

				if(abs(pointOne.getY() - pointTwo.getY()) <= 0.001 && abs(pointOne.getY() - pointTwo.getY()) > 0){

						//point one & two's edge are parallel
						return pointOne.distance(pointTwo);


				}else if(abs(pointTwo.getY() - pointThree.getY()) <= 0.001 && abs(pointTwo.getY() - pointThree.getY()) >= 0){

						//point two & three's edge are perallel
						return pointTwo.distance(pointThree);

				}else if(abs(pointThree.getY() - pointFour.getY()) <= 0.001 && abs(pointThree.getY() - pointFour.getY()) >= 0){

						//point three & four's edge are perallel
						return pointTwo.distance(pointFour);

				}else if(abs(pointFour.getY() - pointOne.getY()) <= 0.001 && abs(pointFour.getY() - pointOne.getY()) >= 0){

						//point four & one's edge are parallel
						return pointFour.distance(pointOne);
				}else
					return 0;
		}


		//Finds what is Parallel to the Y Axis and returns the length
		double Rectangle::whichIsParallelYAxis(){
				if(abs(pointOne.getX() - pointTwo.getX()) <= 0.001 && abs(pointOne.getX() - pointTwo.getX()) >= 0){

						//point one & two's edge are parallel
						return pointOne.distance(pointTwo);


				}else if(abs(pointTwo.getX() - pointThree.getX()) <= 0.001 && abs(pointTwo.getX() - pointThree.getX()) >= 0){

						//point two & three's edge are perallel
						return pointTwo.distance(pointThree);

				}else if(abs(pointThree.getX() - pointFour.getX()) <= 0.001 && abs(pointThree.getX() - pointFour.getX()) >= 0){

						//point three & four's edge are perallel
						return pointThree.distance(pointFour);

				}else if(abs(pointFour.getX() - pointOne.getX()) <= 0.001 && abs(pointFour.getX() - pointOne.getX()) >= 0){

						//point four & one's edge are parallel
						return pointFour.distance(pointOne);
						

				}else
					return 0;
		}


	
//end of class