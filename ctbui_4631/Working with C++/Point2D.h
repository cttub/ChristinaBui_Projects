/*
   @author Dr. Christopher Summa
   @version 1.1
   
 */

#ifndef POINT2D_H

class Point2D {

    /*
     default constructor - this constructor calls the other one
     giving default x and y coordinates of 0.0 , 0.0
    */
    public :

    /* 
     constructor taking two doubles as arguments for the
     x and y coordinates, with 0.0 as default parameters

     param x The initial horizontal coordinate of this point2D
     param y The initial vertical coordinate of this point2D
    */

        Point2D(double x = 0.0, double y = 0.0);
        Point2D(const Point2D& other);
        virtual ~Point2D();

    /* 
     return The horizontal coordinate of this point2D
    */
        double getX() const;

    /* 
     return The vertical coordinate of this point2D
    */
        double getY() const;

    /* 
     param newX The new horizontal coordinate of this point2D
    */
        void setX(double newX);

    /* 
     @param newY The new vertical coordinate of this point2D

     @custom.ensure  getY() == newY
    */
        void setY(double newY);

    /** 
     @param coords an array containing the new x and y coordinate of this point2D

     @custom.require coords.length == 2
     @custom.ensure  getX() == coords[0]
     @custom.ensure  getY() == coords[1]
    */
        void setCoords(double coords[]);

    /** 
     @param newX The new horizontal coordinate of this point2D
     @param newY The new vertical coordinate of this point2D

     @custom.ensure  getX() == newX
     @custom.ensure  getY() == newY

    */
        void moveTo(double x, double y);

    /** 
     @param dx how far to move this point2D horizontally
     @param dy how far to move this point2D vertically

     @custom.ensure  this.getX() == old.getX() + dx
     @custom.ensure  this.getY() == old.getY() + dy

    */
        void moveBy(double dx, double dy);

    /** 
     calculates this distance from the current point to another point,
     accessed by a reference passed in to this method.

     @param other a reference to another Point2D object

     @return distance from this Point2D object to the one passed in as an argument

     @custom.ensure this.distance(Point2D other) >= 0.0

    */
        double distance(Point2D& other) const;

    /*
     Overloading the equals operator

     determines if two points are equal in their coordinates with a tolerance of 0.01 

     @param rhs a reference to another Point2D object

     @return true if the difference between the x coordinate of this point and o is less than tolerance, and the difference between the y coordinate of this point and that of o is less than the tolerance.  false otherwise.
*/

    virtual bool operator== ( const Point2D& rhs ) const;

    private:

        // instance variables
         double coords[2];

}; // end class
#define POINT2D_H
#endif
