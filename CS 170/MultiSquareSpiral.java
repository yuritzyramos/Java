public class MultiSquareSpiral {

  public static void main(String[] args) {
    Turtle erin = new Turtle();

    erin.penup();
    erin.backward(460);
    erin.pendown();
    multiSquare(erin, 20, 5);

    erin.penup();
    erin.forward(140);
    erin.pendown();
    multiSquare2(erin, 20, 5);

    erin.penup();
    erin.forward(220);
    erin.pendown();
    concentricSquares(erin, 20, 5);

    erin.penup();
    erin.forward(240);
    erin.pendown();
    squareSpiral(erin, 10, 20);

    erin.penup();
    erin.forward(230);
    erin.pendown();
    squareSpiral2(erin, 10, 20);
  }

  public static void square(Turtle t, double x) {
    for (int i = 0; i < 4; i++) {
      t.forward(x);
      t.left(90);
    }
  }

  public static void multiSquare(Turtle t, double base, int numSquares) {
    for (int i = 0; i < numSquares; i++) {
      square(t, (i + 1) * base);
    }
  }

  public static void multiSquare2(Turtle t, double base, int numSquares) {
    for (int i = 1; i <= numSquares; i++) {
      square(t, i * base);
    }
  }

  public static void concentricSquares(Turtle t, double base, int numSquares) {
    for (int i = 0; i < numSquares; i++) {
      square(t, (2 * i + 1) * base);
      t.penup();
      t.backward(base);
      t.right(90);
      t.forward(base);
      t.left(90);
      t.pendown();
    }
    t.penup();
    t.forward(base * numSquares);
    t.left(90);
    t.forward(base * numSquares);
    t.right(90);
    t.pendown();
  }

  public static void squareSpiral(Turtle t, double base, int numSides) {
    for (int i = 0; i < numSides; i++) {
      t.forward((i + 2) * base);
      t.left(90);
      t.forward(base*2);
    }
    for (int i = numSides - 1; i >= 0; i--) {
      t.right(90);
      t.backward((i + 1) * base);
    }
  }

  public static void squareSpiral2(Turtle t, double base, int numSides) {
    for (int i = 0; i < numSides; i++) {
      t.forward((i + 1) * base);
      t.left(90);
    }
    for (int i = 0; i < numSides; i++) {
      t.right(90);
      t.backward((numSides - i) * base);
    }
  }

}