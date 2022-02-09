public class RoseSquare{
	public static void main(String[] args){
		Turtle t = new Turtle();
		//position turtle to draw
		 t.fill();
		 t.delay(1);
		 t.penup();
		 t.left(90);
		 t.forward(100);
		 t.pendown();

		roseSquare(t,100,0);
		//roseSquare(t,100,1);
		//roseSquare(t,300,2);
		 //roseSquare(t,200,4);
		 //roseSquare(t,500,5);
		 roseSquare(t,500,10);
	}
public static void roseSquare(Turtle t, double length, int level){
	 int red = 255 - (255/(level+1));
    int green = 0;
    int blue = 255/(level+1);
    t.color(red, green, blue);

	if(level == 0){
		 square(t,length);
		
	}
	else{
		double tilt1 = Math.random() * 30 - 15
		square(t,length);
		t.right(90 + tilt1);
		t.forward(length/2);
        t.left(135);
        innerSquares(t,length -(length*.3),level-1);   
	}
}
public static void square(Turtle t, double length){
	for(int i = 0; i < 4; i++){
		t.forward(length);
		t.right(90);
	}
}
}