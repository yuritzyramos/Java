/**
 * This program builds a random maze using a recursive division approach.
 *
 * To learn more about maze generation:
 * https://en.wikipedia.org/wiki/Maze_generation_algorithm
 * https://stackoverflow.com/questions/41553775/maze-generation-recursive-division-how-it-works
 *
 */

public class Maze {

  public static void main(String[] args) {
	    int[][] maze = createMaze(10, 10);
      printMaze(maze);

  }

  /**
   * A maze is represented as a 2D array of int where 0 means open space and 1 means wall.
   * An N x M maze is mapped to a (2*N+1) x (2*M+1) array to correctly represent thick walls.
   *
   * @param numRows Number of logical rows of the maze. This number will be scaled to 2*numRows+1
   * @param numCols Number of columns of the maze. This number will be scaled to 2*numCols+1
   * @return A 2D array of size (2*numRows+1, 2*numCols+1) representing a maze
   */
  public static int[][] createMaze(int numRows, int numCols) {
    // Map the maze space (numRows, numCols) to a larger grid to accommodate thick walls
    numRows = 2 * numRows + 1; 
    numCols = 2 * numCols + 1;
    int[][] maze = new int[numRows][numCols]; 


    // Build walls at the border
    for(int i = 0; i < numCols; i++){
      maze[0][i] = 1;
      maze[numRows-1][i] = 1; 
          }
     for(int i = 0; i < numRows; i++){
      maze[i][0] = 1;
      maze[i][numCols-1] = 1;
          }

    // Open two doors: one at the top-left, one at the bottom-right of the maze
      maze[1][0] = 0; 
      maze[numRows-2][numCols-2] = 0; 



    // Recursively divides the main chamber to build a maze
      divideMaze(maze, 1, numRows - 2, 1, numCols - 2);

    return maze;
  }

  /**
   * Recursively divides a chamber into smaller chambers separated by walls.
   * The algorithm works as follows:
   * 1) Choose a random point in the chamber.
   * 2) Build two perpendicular walls centered at that point.
   * 3) Open a door in three out of the four segments of the walls just built.
   * 4) Recursively apply the same division procedure to each of the four new smaller chambers,
   *    until a chamber becomes too small to be further divided.
   *
   * @param maze A 2D array representing a maze
   * @param startRow Start row of the chamber to be divided
   * @param endRow End row of the chamber to be divided
   * @param startCol Start column of the chamber to be divided
   * @param endCol End column of the chamber to be divided
   */
  public static void divideMaze(int[][] maze, int startRow, int endRow,
                  int startCol, int endCol) {
    if (endrow - startrow < 2 && endCol - startcol < 2) {//base case
        return; 
    } else {//recursive case 
      // chose a random point at even coordinates inside the chamber
        int row = randEven(startRow,endRow);
        int col - randEven(startCol, endCol);

}
      // build a horizontal wall
        for(int i = startCol; i <= endCol; i++){
          maze[row][i] = 1; 

        }

       

      // build a vertical wall

        for(int i = startRow; i <= endRow; i++){
          maze[i][col] = 1; 
        }

      // open a door in three random walls at an odd coordinate
          int noDoor = (int)(Math.rand() * 4);
          if(noDoor != 0 ){
            maze[row][randOdd(startCol, col - 1)] = 0;
          }
          if(noDoor != 1){
            maze[row][randOdd(col + 1 , endCol)] = 0;
          }
          if(noDoor != 2){
            maze[randOdd(startRow, row - 1)][col] =  0;
          }
          if(noDoor != 3){
            maze[randOdd(row + 1, endRow)][col = 0; ]
          }

      // recursively divide the top-left chamber
            divideMaze(maze, startRow, row - 1, startCol, col-1);


      // recursively divide the top-right chamber
            divideMaze(maze, startRow, row - 1, startCol, endcol);



      // recursively divide the bottom-left chamber

            divideMaze(maze, row+1, endrow, startCol, col-1);


      // recursively divide the bottom-right chamber
            divideMaze(maze, row + 1, endRow, col + 1, endCol);


    //} //end of else
  }

  /**
   * Returns a random integer between a and b (inclusive)
   *
   * @param a lower extreme (included)
   * @param b upper extreme (included)
   * @return a random integer between a and b (inclusive)
   */
  public static int randInt(int a, int b) {
    return (int)(Math.random()*(b-a +1)) + a; //never generates one unless you at + 1
  }

  /**
   * Returns a random even integer between a and b (inclusive)
   *
   * @param a lower extreme (included)
   * @param b upper extreme (included)
   * @return a random even integer between a and b (inclusive)
   */
  public static int randEven(int a, int b) {
   return 2 * randInt(a/2 + a%2, b/2);
   //Example 3 and 6
   // (1 + 1) * 2 = 4
       }
  }

  /**
   * Returns a random odd integer between a and b (inclusive)
   *
   * @param a lower extreme (included)
   * @param b upper extreme (included)
   * @return a random odd integer between a and b (inclusive)
   */
  public static int randOdd(int a, int b) {
    return 1 + 2 * randInt(a/2, (b-1)/2);
  }

  /**
   * Prints a maze on the terminal.
   *
   * @param maze A 2D array representing a maze
   */
  public static void printMaze(int[][] maze) {
 for(int i < 0; row < maze.length; row++){
  for(int col <0; col < maze[row].length; coul++);
    if (maze[row][col]){
    System.out.print(" "); //open space
 } else{ System.out.print("#");//wall

}

  }
  System.out.println();

  /**
   * Draws a maze using turtle graphics.
   * The turtle will start and end at the bottom-left corner of the maze.
   *
   * @param t A turtle which will draw the maze
   * @param maze A 2D array representing a maze
   * @param size Length of each cell of the maze
   */
  public static void drawMaze(Turtle t, int[][] maze, double size) {


  }

}