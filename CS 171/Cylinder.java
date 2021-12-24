/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE 
RESOURCES. Yuritzy Ramos */
public class Cylinder extends Circle{

//Instance variables for class Cylinder that extends from class Circle 
protected double x;//This variable represents the x-coordinate
protected double y;//This varaible represents the y-coordinate 
protected double z;//This variable represents the z-coordinate
protected double H;//This variable represents the height
protected double radius;//This variable represents the radius of the cylinder's bottom

public Cylinder(){//Default constructor
super();//call constructor from Circle class
//Initialize instance variables
x = 0.0;
y = 0.0;
z = 0.0;
H = 1.0;
radius = 1.0;
}
//Overloaded constructor that takes in inputs for the x-coordinate, y-coordinate,
	// the radius of the cylinder, and the height of the cylinder
		//the z-coordinate remains at the original default value
public Cylinder(double xCoordinate, double yCoordinate, double cylinderRadius, double cylinderHeight){
x = xCoordinate;//x-coordinate assigned to variable x
y = yCoordinate;//y-coordinate assigned to variable y
z = 0.0;//Instance variable z set at default value
radius = cylinderRadius;//cylinderRadius assigned to variable radius
H = cylinderHeight;//cylinderHeight assigned to variable H
}

//This method returns the height of the cylinder
public double getHeight(){ 
return H;//Returns the value of H 
}

//This method sets the height of the cylinder to the inputed vaule of type double
	//This method returns nothing 
public void setHeight(double h){
this.H = h;//Reference the height of the current object and set it equal to H (input)
}

@Override
public double getArea(){ 
super.setRadius(radius);//Invokes setRadius from the circle superclass in order to
							//set the radius used in getArea() to that of the cylinder 
return  (2* Math.PI * radius * H) + (2*super.getArea());//Invokes the getArea() method from the circle superclass
															//returns the area of the cylinder 
}
public double getVolume(){
	super.setRadius(radius);//Invokes setRadius() from the circle superclass in order to
								//set the radius used in getArea() to that of the cylinder 
	return H * super.getArea();//Computes the product of the cylinder's height and the area of its bottom 
									//The area of the circular bottom is calculated by invoking the getArea() 
										//method form the circle superclass
								 			//Returns the volume of the cylinder
	}
}