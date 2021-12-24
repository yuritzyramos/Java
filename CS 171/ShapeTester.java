/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE 
RESOURCES. Yuritzy Ramos */

public class ShapeTester {

  // [2 points] Write the method isLarger which takes as input two shapes
  // (a Circle first, then a Rectangle) and returns true if the area of
  // the circle is bigger than (or equal to) the area of the rectangle,
  // false otherwise.

  public boolean isLarger(Circle c, Rectangle r){ //Method of type boolean with shape parameters 
    // referenced from the Circle and Rectangle classes

    double circle = c.getArea();//Assigns the area of c to variable circle using the getArea() method from class Circle

    double rectangle = r.getArea();//Assigns the area of r to varaible reactangle using the getArea() 
                                        //method from class Rectangle
    if(circle >= rectangle){ //If the area of circle is greater than or equal to rectangle...
    return true; //Return true 
    }else{
    return false;// Returns false
    }
  }

  // [2 points] Write the method longerPerim which takes as input
  // a Circle object followed by a Rectangle object and returns
  // the length of the perimeter of the longer of the two objects.

  public double longerPerim(Circle c, Rectangle r){//Method of type double with shape parameters 
    // referenced from the Circle and Rectangle classes
    double circlePeri = c.getCircumference();//Assigns the perimeter of c to variable circlePerim 
                                                //using getCircumference() method from class Circle
    double rectPerim = r.getPermimeter();//Assigns the perimeter of r to variable rectPerim 
                                            //using getPerimeter() method from class Rectangle

    if(circlePeri >= rectPerim){//If the perimeter of the circle is greater than 
                                  //or equal to the perimeter of the rectangle
      return circlePeri;//Return the perimeter of the circle 
    } else{
      return rectPerim;//Otherwise the perimeter of the rectangle 
    }
  }

  //[2 points] Write another version of the method longerPerim which has the
  // same name and functionality but it takes as input a Rectangle object
  // followed by a Circle object. The method also returns the length of
  // the perimeter of the longer of the two objects.

public double longerPerim(Rectangle r, Circle c){//Method of type double which takes in the shape parameter rectangle 
                                                    //followed by the shape parameter circle
   double circlePeri = c.getCircumference();//Assigns the perimeter of c to variable circlePerim 
                                                //using getCircumference() method from class Circle
    double rectPerim = r.getPermimeter();//Assigns the perimeter of r to variable rectPerim 
                                            //using getPerimeter() method from the Rectangle class 
    if(rectPerim >= circlePeri){//If the perimeter of the inputed rectangle is greater than 
                                  //or equal to the perimeter of the inputed circle
      return rectPerim;//Return the perimeter of the rectangle 
    } else{
      return circlePeri;//Otherwise return the perimeter of the circle 
    }
}

  // TODO: [2 points] Write the method largerArea which takes as input
  // a Circle object followed by a Rectangle object and returns
  // the area of the larger of the two objects.

  public double largerArea(Circle c, Rectangle r){//Method of type double that takes as inputs two shapes 
                                                      //a circle followed by a rectangle 
    double circle = c.getArea();//Assigns the area of the c to variable circle 
                                        //using the getArea() method from the Circle class
    double rectangle = r.getArea();//Assigns the area of r to var rectangle
                                        //using the getArea() method from the Rectangle class
    if(circle >= rectangle){//If the area of the circle is greater than or equal to the area of the rectangle 

      return circle;//Return area of circle
    }else{
      return rectangle;//Otherwise return the area of rectangle
    }
  }
  //[2 points] Write another version of the method largerArea which has the
  // same name and functionality but it takes as input a Rectangle object
  // followed by a Circle object.
   public double largerArea(Rectangle r, Circle c){//Method of type double that takes as inputs two shapes 
                                                      //a rectangle followed by a circle
    double circle = c.getArea();//Assigns the area of r to var rectangle
                                        //using the getArea() method from the Rectangle class
    double rectangle = r.getArea();//Assigns the area of r to var rectangle
                                        //using the getArea() method from the Rectangle class
    if( rectangle >= circle){//If the area of the circle is greater than or equal to the area of the rectangle 

      return rectangle;//Return area of rectangle
    }else{
      return circle;//Otherwise return area of circle
    }
  }
  //[10 points] Write the method containsCenter which takes as input two circles,
  // and returns true if the first circle contains the center of the second circle,
  // false otherwise.
  public boolean containsCenter(Circle c1, Circle c2){//Method of type boolean that takes as input two circles 
                                                            //referenced from the Circle class
  double radius = c1.getRadius();//Assigns the radius of c1 to variable radius

  double[] center = c2.getCenter();//Assigns the center of c2 to variable center

  double x = center[0];//Assigns the element at the 0th index of the array to variable x

  double y = center[1];//Assigns the element at the 1st index of the array to variable y
  if((radius > x) && (radius > y)){//If the radius of c1 is greater than the vaule of x (x-coordinate of center)
                                        //and greater than the value of y (y-coordinate of center)
    return true;//Return true
  }else{
    return false;//If this condition isn't met return false
      }
    }
 }