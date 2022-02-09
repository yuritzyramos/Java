public class medievalTown{
  public static void main(String[] args) {
    Turtle yo = new Turtle();
yo.fast(1);
    yo.penup();
    yo.backward(400);
    yo.left(90);
    yo.forward(100);
    yo.right(90);
    yo.pendown();
    // makes the first mountain
    mount(yo);

    // positions turtle for start of the next mountain
    yo.penup();
    yo.left(Math.toDegrees(Math.atan(2)));
    yo.backward(40);
    yo.left(90);
    yo.forward(80);
    yo.right(90);
    yo.pendown();

    // makes the second mountain
    mount(yo);

    // positions turtle for start of next mountain
    yo.penup();
    yo.left(Math.toDegrees(Math.atan(2)));
    yo.backward(10);
    yo.left(90);
    yo.forward(20);
    yo.right(90);
    yo.pendown();

    // makes third mountain
    mount(yo);
    yo.left(Math.toDegrees(Math.atan(2)));

    // positions turtle to make windows on left tower
    yo.penup();
    yo.backward(520);
    yo.right(90);
    yo.forward(50);
    yo.left(90);
    yo.pendown();


    // makes windows on left tower
    windows(yo);
    yo.penup();
    yo.forward(40);
    yo.right(90);
    yo.forward(30);
    yo.left(90);
    yo.pendown();

    // makes castle towers, brick walls, entrance arc
    tower(yo);
    brickWall(yo);
    arcs(yo);
    yo.left(180);
    yo.penup();
    yo.forward(40);
    yo.pendown();
    brickWall(yo);
    yo.forward(50);
    tower(yo);

    // positions turtle to make and makes windows on right tower
    yo.penup();
    yo.left(90);
    yo.forward(90);
    yo.right(90);
    yo.backward(40);
    yo.pendown();
    windows(yo);

    // positions turtle to make and makes arcs on the right sides
    yo.penup();
    yo.forward(60);
    yo.pendown();
    for(int i =0;i<3;i++){
      arcs(yo);
      yo.left(180);
      yo.penup();
      yo.forward(50);
      yo.left(90);
      yo.forward(20);
      yo.right(90);
      yo.pendown();
    }
    //position turtle to make trees
    yo.penup();
    yo.backward(80);
    yo.right(90);
    yo.forward(100);
    yo.left(180);
    //make trees
    Trees(yo,100);
     //position turtle for next line of trees
     yo.penup();
     yo.forward(20);
     yo.left(90);
     yo.forward(80);
     yo.right(90);
     //make trees
     Trees(yo,100);
     Return(yo);
    //make stars
      star1(yo);
      Star(yo,10);
      star2(yo); 
      Star(yo,10);
      star3(yo);
      Star(yo,10);
      star4(yo);
      Star(yo,10);
      star5(yo);
      Star(yo,10);
      star6(yo);
      Star(yo,10);
      star7(yo);
      Star(yo,10);
      star8(yo);
      Star(yo,10);
      yo.hideturtle();
