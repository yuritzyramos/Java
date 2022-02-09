public class CompareCars{
	/*
	If you plan on keeping the car for 5 years then you should Car A because it is about $7,340 less than Car B
	If you plan on keeping the car for 10 years then you should buy Car B because it is about $457.40 less than Car A.

    When you "return" a value in a method, a variable intialized within it is returned after an operation has been applied to it x 
    amount of times. For example, multiplying a number x amount of times and returning the output for each iteration. 
    When you "print" something within a method, it is executed x number of times but it is never altered. For example, printing the
    string "Apple" x amount of times.
    */

public static void main (String[] args){
	System.out.println(compareCars(2));
	System.out.println(compareCars(5));
	System.out.println(compareCars(10));
	System.out.println(compareCars(20));
	}

// Calculates total cost of carA for # of years given
// prints table from year 0 to given year
public static double carA(int years){
int i = 0;
double money = 20000.00;
System.out.println("---- Car A ----");
System.out.println("year \t money");
 
while( i <= years ){
	System.out.println( i + "\t" + money);
    money = money + ((1500) + (1300 * (Math.pow(1.15, i)))); 
     i++;
	} 
	return money;
	}

// Calculates total cost of carB for # of years given
// prints table from year 0 to given year
public static double carB(int years){
int i = 0;
double money = 30000.00;
System.out.println("---- Car  B----");
System.out.println("year \t money");
 
while( i <= years ){
	 System.out.println( i + "\t" + money);
    money = money + ((1500) + (1000 * (Math.pow(1.10, i)))); 
     i++;
	} 
	return money;
	}
	
// Calls carA and carB methods 
// Compares price of carA and carB on the last year
//Returns the most affordable cars after a number of given years 
public static String compareCars(int years){
	double carA = carA(years);
	double carB = carB(years);
	if(carA < carB) {
		System.out.println("");
		return "The most affordable care is Car A";
	}
	else {
		System.out.println("");
		return "The most affordable care is Car B";
	}
}
}