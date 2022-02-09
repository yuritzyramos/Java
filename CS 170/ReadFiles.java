import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class ReadFiles {

  // We will discuss what "throws FileNotFoundException" means next lecture ;-)
  public static void main(String[] args) throws FileNotFoundException {

    // ----------------------------------------------- //
    // From last lecture: replaceAll()
    String text = "To be, or not to be. That is the question.";
    // Q1: Replace with:
    // "To be, or not to be. That is the queeestion."
    //System.out.println(replaceAll("e","eee")); //wouldn't work 
    //System.out.println(replaceAll("e\\w", "eee"));//wouldn't work
    System.out.println(text.replaceAll("(e)(\\w)", "$1$1$1$2"));
    //Grouping system ($ and #s)
    //"(\\w)(\\s)(\\w)(\\S)" 
    //   1    2    3    4
    //$1$4 <-- final result (what you want) 



    // Someone messed up the text... let's fix it!
    text = "To be , or not to be. That is the question .";
    text = fixString(text);
    System.out.println(text);

    /* Sources:
      Section 3.4: Grouping and back reference
      Section 3.5: Negative look ahead
      https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
      More Exercises: http://regex.sketchengine.co.uk/cgi */
    // ----------------------------------------------- //


    // Q3: Now let's read the text from a file instead (everything in this example is line by line)
    String fileName = "example1.txt";

    // Step 1: create a File object (input is string)
    File file = new File(fileName);
    //File file = new File("example1.txt"); //both statements are equal 

    // Some supported functions in Java:
    System.out.println(file.canRead());
    System.out.println(file.canWrite());
    System.out.println(file.isFile());
    System.out.println(file.isDirectory());
  //  System.out.println(file.deleteFile()); //be careful with the delete function
    System.out.println("File Path: " + file.getPath());
    System.out.println("File Absolute Path: " + file.getAbsolutePath());
    System.out.println("File exists: " + file.exists());

    // Step 2: create Scanner object
//scanner goes through the characters in a text file  
    Scanner scan = new Scanner(file);


    // Step 3: read file line by line
    while(scan.hasNextLine()){ //has long as there is another line in the file 
      String line = scan.nextLine(); //save it in line variable 
      System.out.println(fixString(line)); //put line through fixstring method and print out result
    }

    // Step 4: remember to close the scanner object!
    scan.close(); //have to close so you don't get an error



    // More file input examples:
    String fileName2 = "example2.txt"; // try: example2_newline.txt
    System.out.println(calcAverageFromFile(fileName2));
    double[] grades = readGradesFromFile(fileName2);
    for(int i = 0; i < grades.length;i++){
      System.out.println(grades[i]);
    }
    // Test: calcAverageFromFile(fileName2)
    // Test: readGradesFromFile(fileName2)
    // Test: fileMatchAndPrint("hamlet.txt")
    String fileName4 = "hamlet.txt";
    fileMatchAndPrint(fileName4);
  }


  // Q2: Remove white space between a word character and . or ,
  public static String fixString(String str) {
    String pattern = "(\\w)(\\s+)([\\.,])"; // square brackets is saying either dot ot comma
   return str.replaceAll(pattern,"$1$3");
  }

  // Q4: Read double values from a file and return their average
  public static double calcAverageFromFile(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner s = new Scanner(file);
    double sum = 0; 
    int count = 0; 
   
   while(s.hasNextDouble()){
      sum+= s.nextDouble();
      count++;
    }
    s.close();
    return sum/count;
  }

  // Q5: Read double values from a file and store them
  // into an array, then return the array
  public static double[] readGradesFromFile(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    
    Scanner s = new Scanner(file);
    int space = 0;
   while(s.hasNextDouble()){//counts the number of doubles 
    s.nextDouble();           //so we can assign it to the array 
    space++;
    }
    s.close(); //always close scanner!

    //create result array with the correct space
    double[] result = new double[space];//create a new array
    //read file again fill in the array 
    s = new Scanner(file); //call scanner again
    int i = 0; //index of array
    while(s.hasNextDouble()){ //while there is a double
      result[i] = s.nextDouble(); //assign the double to index i of the array
      i++; //increase index
    }
    s.close();//always close scanner!
    return result; //return array
  }

  // Q6: Read lines from file and print them while replacing
  // "to", "too", or "two" (case insensitive) with the number 2
  public static void fileMatchAndPrint(String fileName) throws FileNotFoundException {
    Scanner s = new Scanner(new File(fileName));
    while(s.hasNextLine()){
      String line = s.nextLine();
      String fixedline = line.replaceAll("[Tt][OoWw]?[Oo]","2");
      System.out.println(fixedline);
    }
      s.close(); 
  }

}