/**
   @author Dr. Christopher Summa
   @version 1.1
   
 */

#include "Point2D.h"
#include <math.h>

    /** 
     default constructor taking two doubles as arguments for the
     x and y coordinates

     @param x The initial horizontal coordinate of this point2D
     @param y The initial vertical coordinate of this point2D

     @custom.ensure  getX() == x
     @custom.ensure  getY() == y
    */

    Point2D::Point2D(double x, double y) {
        coords[0] = x;
        coords[1] = y;
    }

    /*
    destructor - since the creating of one of these doesn't "new" anything, we don't need to "delete" anything
    */
    Point2D::~Point2D() {
    }

    /** 
     @return The horizontal coordinate of this point2D
    */
    double Point2D::getX() const {
        return coords[0];
    }

    /** 
     @return The vertical coordinate of this point2D
    */
    double Point2D::getY() const {
        return coords[1];
    }

    /** 
     @param newX The new horizontal coordinate of this point2D

     @custom.ensure  getX() == newX
    */
    void Point2D::setX(double newX) {
        coords[0] = newX;
    }

    /** 
     @param newY The new vertical coordinate of this point2D

     @custom.ensure  getY() == newY
    */
    void Point2D::setY(double newY) {
        coords[1] = newY;
    }

    /** 
     @param coords an array containing the new x and y coordinate of this point2D

     @custom.require coords.length == 2
     @custom.ensure  getX() == coords[0]
     @custom.ensure  getY() == coords[1]
    */
    void Point2D::setCoords(double modcoords[]) {
        this->coords[0] = modcoords[0];
        this->coords[1] = modcoords[1];
    }

    /** 
     @param newX The new horizontal coordinate of this point2D
     @param newY The new vertical coordinate of this point2D

     @custom.ensure  getX() == newX
     @custom.ensure  getY() == newY

    */
    void Point2D::moveTo(double x, double y) {
        this->coords[0] = x;
        this->coords[1] = y;
    }

    /** 
     @param dx how far to move this point2D horizontally
     @param dy how far to move this point2D vertically

     @custom.ensure  this.getX() == old.getX() + dx
     @custom.ensure  this.getY() == old.getY() + dy

    */
    void Point2D::moveBy(double dx, double dy) {
        this->coords[0] += dx;
        this->coords[1] += dy;
    }

    /** 
     calculates this distance from the current point to another point,
     accessed by a reference passed in to this method.

     @param other a reference to another Point2D object

     @return distance from this Point2D object to the one passed in as an argument

     @custom.ensure this.distance(Point2D other) >= 0.0

    */
    double Point2D::distance(Point2D& other) const {
        double dX = this->getX() - other.getX();
        double dY = this->getY() - other.getY();
        double dist = sqrt( dX * dX + dY * dY );
        return dist;
    }

    /** 
     determines if two points are equal in their coordinates with a tolerance of 0.01 

     @param rhs a reference to another Point2D object
    
     consider the following expression (assume p1 and p2 are Point2D objects):
        p1 == p2

     The way this works in c++ is the one left is "this" (the one whose overloaded == operator method
     is invoked, and the one on the right is "rhs" the one whose reference is the parameter passed into the
     method

     @return true if the difference between the x coordinate of this point and o is less than tolerance, and the difference between the y coordinate of this point and that of o is less than the tolerance.  false otherwise.

    */

bool Point2D::operator== ( const Point2D& rhs ) const
{
    if ( abs(getY() - rhs.getY()) < 0.001 &&
         abs(getX() - rhs.getX()) < 0.001    )
           return true;
    return false; 
}
