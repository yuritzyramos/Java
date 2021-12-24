/* THIS CODE WAS OUR OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS 
OR COPIED FROM ONLINE RESOURCES. Yuritzy Ramos and Mimi Olayeye */
/** Add any necessary import statements here **/
import java.util.ArrayList;
import java.util.*; 

// This class represents a dictionary of Klingon words,
// where each word is represented by class "KlingWord"
public class KlingDictionary {
  // one member variable that represents the dictionary as an ArrayList;
  // all methods below will add/read/remove/etc. from this variable
  public ArrayList<KlingWord> dict;

  // constructor
  public KlingDictionary () {
      dict = new ArrayList<KlingWord>();
  }

  // Helper method to build the dictionary "dict" from two String arrays
  // Returns the number of words that have been added successfully
  /*** Warning: Do NOT modify this method ***/
  public int buildDictionary() {
    // A list of Klingon words to be added to this dictionary
    String[] knWordsArray= {"adanji", "baH", "baktag", "batleth", "Bekk", "fote", "forshak", "ghoptu", "lok",	"eff", "grr",	"keshmalek",	"drumpf", "daH", "Kyamo"};
    // The corresponding English translations are stored in the same order below
    String[] enWordsArray = {"perfume", "blah", "insult", "sword", "soldier", "vote", "car", "insult", "look", "insult", "insult", "gameover", "prince", "duh", "Beautiful"};

    // Variables to be used inside the for-loop
    String knWord = "";
    String enWord = "";
    int numWords = 0;
    for(int i = 0; i < knWordsArray.length; i++) {
        knWord = knWordsArray[i];  //read the KN word
        enWord = enWordsArray[i];  //read the corresponding EN translation
        KlingWord word = new KlingWord(knWord, enWord); //create a KlingWord object

        addWord(word); //this will only work properly after you implement addWord() below!!
        numWords++; //update word counter
    }

    return numWords;
  }

  // -------------- Assignment#1 Dictionary Methods Below -------------- //
  /* Add a new Klingon word to the dictionary member variable "dict".
  * The dictionary must NOT include duplicate Klingon words; however,
  * two (or more) Klingon words may have the same English translation (i.e. same "en").
  *
  * Return 0 if addition was successful, -1 otherwise. */
  public int addWord(KlingWord newWord) {

    String newWordKnTemp = newWord.getKN();//temporary holder for 'newWord' object's KN word (getKN() retrieves KN word).
    int y = -1; // initializition for y (0 if addition was successful, -1 otherwise.)
    int count = 0; // initializtion of counter for duplicate Klingon words
    String klingWord = "";//initializtion for Klingon words retrieved from the dictionary (dict)

    for (int i=0; i < dict.size(); i++) {//Iterates through the dictionary

     klingWord = (dict.get(i)).getKN();//Assigns the Klingon word at index i of the dictionary
                                        //to the string variable 'klingWord'

//Converts klingWord and newWordKNTemp to lowercase letters making the dictionary case insensitive 
     //Checks to see if the two strings are equal to each other 
      if (klingWord.toLowerCase().equals(newWordKnTemp.toLowerCase())){
        count ++;//If both strings are equal add 1 to the counter; the inputed word is a duplicate
      } 
    } 
      
    if (count == 0){//If count equals 0; the inputed word (newWord) is not a duplicate 
                      //of any pre-existing words in the dictionary 
      dict.add(newWord);//Add the new word to the dictionary 
        y = 0;//Assign the value of 0 to variable y 
    }
    else{//If the inputed string already exists in the dictionary
      y=-1;//Assign -1 to variable y; the new word is not added to the dictionary 
    }

    return y;//Return the value of y to the user 
    
  }

  /* Check if the Klingon word in "oldWord" exists in the dictionary "dict"
  * (regardless of the English meaning), then:
  * If you do find oldWord => remove it from the dictionary then insert "newWord" in
  * the exact same location where you removed oldWorld.
  * If you don't find "oldWord" => add "newWord" normally at the end of the dictionary.
  *
  * Return 0 if a replacement did happen (i.e. you found oldWord), -1 otherwise. */
  public int replaceOrAddWord(KlingWord oldWord, KlingWord newWord) {
  
  int y = -1;//Initialize a variable y of type int with a value of -1 
  String oldWordTemp = oldWord.getKN();//Temporary holder for the Klingon word of the object oldWord
  int count = 0;//Initialize counter to keep track of repeats

      for (int i = 0; i< dict.size() ; i++) {//Iterates through the dictionary 
        if ((dict.get(i)).getKN() == oldWordTemp){// Checks to see if the Klingon word at index i of the dictionary 
                                                    //is equal to the Klingon word of the oldWord object
          //If the Klingon word retreived from oldWord exists in the dictionary...
           dict.remove(i);//Remove the word at index i from the dictionary
           dict.add(i, newWord);//Add the inputed newWord object to the dictionary at index i 
           y = 0;//Set variable y to 0
           count++;//Add one to counter; signifies that the Klingon word in oldWord exits 
                      //within the dictionary
        } 
      }
      if (count < 1){//If the Klingon word of the oldWord object does not exist in the dictionary...
        dict.add(newWord);//Add newWord to the end of the dictionary
        y = -1;//Set variable y to -1; oldWord was not found in dictionary
      }
      
      return y;//Return the value of y to the user
  }



  /* Delete all Klingon words that have the English meaning given
  * in "badEN" from the dictionary "dict".
  *
  * Return the number of words that were deleted successfully. */
  public int deleteFromDict(String badEN){
    int count = 0;//Initlize counter to keep track of deleted words

    for (int i=0; i<dict.size(); i++) {//Iterates through dictionary 
      if((dict.get(i)).getEN() == badEN){//If the English word retrieved from index i of dict   
                                            //equals the inputed word (badEn)
          dict.remove(i);//Remove the word at index i 
          count++;//Add one to the counter
          i--;//Subtract one from i to account for the shifting of the elements in the arraylist to the left 
                //Ensures that the next element isnt skipped
      } 
    }
    return count;//Return the value of counter; successful deletions
  }


  /* The new Klingon leader decided that long words are just stupid.
  /* Implement this law which removes any Klington word from the dictionary
  /* that is longer than 3 characters (regardless of the English translation's length) */
  public void shortDict(){
    int limit = 3;//Initializes a variable for the length of accepted Klingon words
    String knWordTemp = "";//Temporary holder for Klingon words from the object KlingDictionary 
    for (int i=0; i< dict.size(); i++) {//Iterates through the dictionary 
      knWordTemp = ((dict.get(i)).getKN());//Assigns the Klingon word at index i of dict  
                                                //to the knWordTemp variable
      if(knWordTemp.length() > limit){//If the length of the Klingon word stored in the knWordTemp
                                          //variable is greater than 3 characters
        dict.remove(i);//Remove the word at index i from the dictionary 
        i--;//Subtract one from i to acount for the shifting of the elements in the arraylist to the left
                //Ensures that the next element isnt skipped

      }
      
    }
  }
  /* One dictionary is not enough? Let's create another one!
  * Find all the Klingon words in "dict" whose first and last
  * characters are identical (e.g. "kwerk"). Now create a new dictionary
  * that contains these special words. Don't remove the words from the
  * original dictionary.
  *
  * Return the newly created dictionary. */
  public KlingDictionary createSubDict(){
    KlingDictionary newDict = new KlingDictionary();//Creates a new KlingDictionary object
    String tempKlingWord = "";//Temporary holder for a Klingon word from 'dict' dictionary
    for (int i=0; i< dict.size(); i++){ //Iterates through dictionary
      tempKlingWord = (dict.get(i)).getKN();//Assigns the Klingon word at index i of dict to tempKlingWord
      if (tempKlingWord.charAt(0) == tempKlingWord.charAt(tempKlingWord.length()-1)){//Checks if the first and last character
                                                                                       //of tempKlingWord are the same
        newDict.addWord((dict.get(i)));//If the first and last character of the Klingon word are the same
                                         //Add the word at index i from dict to newDict
      }
    }
    return newDict;//Returns the newDict object 
  }

  //*Prints all the KlingWord objects inside the ArrayList dict.
  /* Remember: the method toString() in class KlingWord will be invoked automatically
  /* when an object of class KlingWord is passed to System.out.println(). */
  public void printDictionary(){
    for( KlingWord kw : dict ){
      System.out.println(kw);
    }
  }


  // Main method includes constructing your dictionary and testing its methods
  public static void main(String[] args) {
    int result;
    KlingDictionary klingdict = new KlingDictionary();

    // Build the dictionary
    result = klingdict.buildDictionary();
    System.out.println("buildDictionary() result => " + result);
    // Print dictionary
    klingdict.printDictionary();

    // Add word
    result = klingdict.addWord(new KlingWord("klingothing","nothing"));
    // Remember, '\n' below stands for: print a "new line"
    System.out.println("\naddKlingWordictoDict() result => " + result);
    klingdict.printDictionary();

    // Replace or add word
    KlingWord testword = new KlingWord("forshak","vehicle");
    KlingWord newWord = new KlingWord("gamma","beta");
    result = klingdict.replaceOrAddWord(testword, newWord);
    System.out.println("\nreplaceOrAddWord(" + testword.getKN() +
                "," + newWord.getKN() + ") result => " + result);
    klingdict.printDictionary();

    // Get special words in a new dictionary
    KlingDictionary specialDict = klingdict.createSubDict();
    System.out.println("\nCalled createSubDict()...");
    specialDict.printDictionary(); // print new dictionary with special words

    // Apply new law that requires removing long words
    klingdict.shortDict();
    System.out.println("\nApplied shortenDict()...");
    klingdict.printDictionary();

    // Delete all words that have this English meaning
    String badEN = "insult";
    result = klingdict.deleteFromDict(badEN);
    System.out.println("\ndeleteFromDict() result => " + result);
    klingdict.printDictionary();

    /* That's all folks! Enjoy! */
  }

}