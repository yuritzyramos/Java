public class PolygonFlower {

  public static void main(String[] args) {
    Turtle erin = new Turtle();
    erin.delay(1); // make the turtle faster (0 = fastest)
    flower(erin, 7, 15, 20);
  }

  public static void polygon(Turtle t, int numSides, double length) {
    for (int i = 0; i < numSides; i++) {
      t.forward(length);
      t.left(360.0 / numSides);
    }
  }

  public static void petal(Turtle t, int numLayers, double length) {
    for (int i = 0; i < numLayers; i++) {
      polygon(t, i + 3, length); ///determines the polygon the petal start off with in this case a triangle (3 sides)
    }
  }

  public static void flower(Turtle t, int numPetals, int numLayers, double length) {
    for (int i = 0; i < numPetals; i++) {
      petal(t, numLayers, length);
      t.forward(length);
      t.right(360.0 / numPetals);
    }
  }

}