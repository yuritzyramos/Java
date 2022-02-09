public class Multisquare{
	 public static void main(String[] args) {
	 	Turtle erin = new Turtle();
	 	multisquare2(erin,25,5);
	}
	public static void square(Turtle t, double x){
		for(int i = 0; i < 4; i++){
			t.forward(x);
			t.left(90);
		}
	}
	public static void multisquare(Turtle t, double base, int numSquares){
		for(int i = 0; i < numSquares; i++){
			square(t,(i+1)*base);
			//+1 compensates for starting at zero
		}
	}
	public static void multisquare2(Turtle t, double base, int numSquares){
		for(int j = 1; j <=numSquares; j++){
			square(t,j*base); 
			//if you use <= when the code gets to the number (in this case numSquares) the code will repeat itself
		}
	}
	public static void concentricSquares(Turtle t, double base, int numSquares){
		for(int k = 0; k<numSquares; k++){
			square(t,(2*k + 1)*base);
			t.penup();
			t.backward(base);
			t.right(90);
			t.forward(base);
			t.left(90);
			t.pendown();
		}
public static void squarespiral(Turtle t, double base, int numSquares){
	for(int k = 0; k<numSquares; k++){
			t.foward((k+1)*base);
			t.left(90);
	}
	for(int k = 0; k < numSquares; )
}