/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE 
RESOURCES. Yuritzy Ramos */

// This class represents a rectangle shape
public class Rectangle {

		private double L; // the length of the rectangle
		private double H; // the height of the rectangle
		private double x; // the x coordinate of the  bottom left corner of the rectangle
		private double y; // the y coordinate of the bottom left corner of the rectangle

		//[3 points] Write a basic constructor that creates a rectangle with
		//side lengths 1 whose bottom left corner is at (0.0,0.0)
		public Rectangle(){
			L = 1.0;//Length of the rectangle's sides
			H = 1.0;//Height of the rectangle
			x = 0.0;//x-coordinate of left corner
			y = 0.0;//y-coordinate of left corner
		}

		//[3 points] Now write a constructor that takes all four inputs,
		// named Ell, Eich, Ex, and Why for L, H, x, and y, respectively.
		public Rectangle(double ell, double eich, double ex, double why){
			 L = ell;//Assign ell to the instance variable L 
			 H = eich;//Assign eich to the instance variable H 
			 x = ex;//Assign ex to the instance variable x 
			 y = why;//Assign why to the instance variable y 
		}

		//[2 points] Write a method called getLength which returns the length.
		public double getLength(){
			return L; 
		}

		//[2 points] Write a method called getHeight which returns the height.
		public double getHeight(){
			return H;//Returns the value of instance variable height
		}

		//[2 points] Write a method called setLength which takes as input a double
		// called Ell and uses it to set the length of the rectangle.
		public void setLength(double ell){
			this.L = ell;//Reference varible from object and assign it to the input
		}

		//[2 points] Write a method called setHeight which takes as input a double
		// called Eich and uses it to set the height of the rectangle.
		public void setHeight(double eich){
			this.H = eich;//Reference varible from object and assign it to the input
		}

		//[3 points] Write a method called perimeter which computes and returns
		// the perimeter of the rectangle.
		public double getPermimeter(){
		return (2*L) + (2*H);// Adds the products of L and H multiplied by 2 (individually)
									//to obtain the perimeter 
		}
		//[3 points] Write a method called area which computes and returns the
		// area of the rectangle.
		public double getArea(){
		return L*H;//Multiples the length and height of the reactangle together to obtain the area 
		}
}