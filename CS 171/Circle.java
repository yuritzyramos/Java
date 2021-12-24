/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE 
RESOURCES. Yuritzy Ramos */

// This class represents a circle shape
public class Circle {

    // Instance variables (data members) of class Circle
    protected double radius; // the radius of the circle
    protected double x; // the x coordinate of the circle's center
    protected double y; // the y coordinate fo the circle's center

    // The default constructor with no argument
    public Circle(){
      // Initializing the values of the instance variables
      radius = 1.0;
      x = 0.0;
      y = 0.0;
    }

    // Second constructor with given radius, but origin default
    public Circle(double r) {
      radius = r;
      x = 0.0;
      y = 0.0;
    }

    //[2 points] Complete this overloaded constructor
    // Parameter r should be the radius length
    // Parameter ex should be the x coordinate
    // Parameter why should be the y coordinate
    public Circle(double r, double ex, double why) {//Overloading the default constructor
    	radius = r; //Assign r to the instance variable radius 
        x = ex;//Assign ex to the instance variable x
        y = why;//Assign why to the instance variable y

    }

    // A public getter method for retrieving the radius
    public double getRadius() {
     return radius;
    }

    // A public getter method for retrieving the center coordinates
    public double[] getCenter() {
     double[] c = {this.x, this.y};
     return c;
    }

    // A public getter method for computing and returning
    // the area of the circle
    public double getArea() {
      return radius * radius * Math.PI;
    }

    //[2 points] A public method you need to write to
    // compute and return the circumference of the circle
    public double getCircumference() {
    	return 2 * Math.PI * radius; // returns the circumference of a cirlce (2πr)
    }

    //A public method that compares the sizes of two circles: the circle
    // represented by the current object, and the circle passed as a parameter.
    // Example: circleA.isBiggerThan(circleB) should return true if circleA
    // has a larger area than circleB, false otherwise.
    // NOTE: You may need to modify the parameter list!

//This method compares the radii of the two circles - that of the current object 
    //and that of the input
        //It returns true if the radius of the current object is greater than the inputed radius
         // since a longer radius corresponds to a bigger area
   public boolean isBiggerThan(double radius) { 

   double circleA = getRadius();//Retrieves the radius of the current object and assigns it to circleA

   double circleB = radius;//Assigns the inputed radius to circleB

//boolean expression compares the radius of the current object to the inputed radius

    if(circleA > circleB){ //If the radius of circleA is bigger than the radius of circleB...
        return true; //Return true to the user
     } else{
        return false;//Otherwise return false
     }
    }

    //[6 points] A public method that takes as input an x coordinate (as a double)
    // and a y coordinate (a double), and returns true if the (x, y) coordinate
    // is inside the current circle, false otherwise.
    // NOTE: You may need to modify the parameter list!

//This method checks if the an inputed point (x,y) is inside of the current object
    //This can be determined by comparing the x and y coordinates (individually) to the length 
        //of the circle's radius
    public boolean containsPoint(double ex, double why) { 
        radius = getRadius(); //Retrieves radius of current object and assigns it to the variable radius

    	if((ex > radius) || (why > radius)){ // If the x OR the y coordinate are bigger than the radius
            return false;//Return false to the user
        }else{ 
            return true; //Otherwise return true
        }
    }

    //[3 points] Write a method named setRadius that sets this object's radius
    // based on the passed parameter (of type double).
    // The method should not return anything.

   public void setRadius(double r){ //Method of type void which takes an input of type double
    this.radius = r;//Reference the radius of the current object and set it equal to r (input)
   }

    //[3 points] Write a method named setCenter that sets this object's center.
    // The method takes two doubles as parameters: ex and why.
    // It should set the x coordinate of the circle to ex,
    // and the y coordinate of the circle to why.
    // The method should not return anything.

   public void setCenter(double ex, double why){ //Method of type void with input parameters of type double
    this.x = ex;//References the x coordinate of the current object and sets it equal to ex (input)
    this.y = why;//References the y coordinate of the current object and sets it equal to why (input)
   }

    //[1 point] Complete the overriden method toString which should
    // return the string representation of this Circle object, as follows:
    // "This circle is centered at point <display_coordinate_of_center_here>
    // with radius <display_radius>"
    @Override
    public String toString() { //Overrides the toString method from the cosmic class
     return "This circle is centered at point (" + x + ", " + y + ") with radius " + getRadius();
     //Use the x and y instance variables from the current object 
        //to obtain the center and retrieve the radius of the circle using the getRadius() method
        }
    }