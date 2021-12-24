/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN 
BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Yuritzy Ramos */

import java.util.*;
public class BSTIndex {

		private class Node {
			private String key;
			private MovieInfo data;
			private Node left, right;

			public Node(MovieInfo info) {
				data = info;
				key = data.shortTitle;
			}
		}

		private Node root;

		public BSTIndex() {
			root = null;
		}

		// --------- [DO NOT MODIFY!] public BST methods  --------- //
		/* Important: Notice that each public method here calls another private method while passing it a reference to the tree root. This is a common way of structuring BST functions such that external client code will not have direct access to the tree root. You will be implementing the code in the private methods, not the public ones. */

		/* Calculate and return the height of the current tree. */
		public int calcHeight(){
				return calcNodeHeight(this.root);
		}

		/* Insert the given data element into the proper place in the BST structure. */
		public void insertMovie(MovieInfo data) {
			root = insertMovie(data, this.root);
		}

		/* Find and return the data element (i.e. the MovieInfo object)
		of the node where the movie's shortTitle matches the given key.
		Return null if the movie is not found. */
		public MovieInfo findMovie(String key) {
			return findMovie(this.root, key);
		}

		/* Print out all movies in the database whose shortTitle begins with
		the passed prefix string. If no movies match the given prefix, nothing
		will be printed. The order of printing does not matter, but make sure
		to print each match in a separate line. */
		public void printMoviesPrefix(String prefix) {
			printMoviesPrefix(this.root, prefix);
		}
		// ----------------- end of public methods ------------------ //


		// ------------- [TODO] private BST methods --------------- //

		//This method returns the height of the BST
		private int calcNodeHeight(Node t) {
		int leftHeight = 0;//Initialize a variable to store the height of the left sub-tree 
		int rightHeight = 0;//Initialize a variable to store the height of the right sub-tree 

		if(t == null){//If the tree is empty or reaches a leaf node (base case)
		return 0;//Return 0 

		}else{
		//Continue recuring left down the tree and right down the tree until a leaf is reached
		leftHeight = calcNodeHeight(t.left);//Add one after every recursion left

		rightHeight = calcNodeHeight(t.right);//Add one after every recursion right

		return  1 + Math.max(leftHeight,rightHeight);//Return the greater of the two values
		}
	}

		//This method inserts an inputed movie data into the correct position in the BST
		private Node insertMovie(MovieInfo data, Node t) {

		String movieTitle = data.shortTitle;//Stores the short title of the data 
     
		if(t == null){//If the tree is empty or the node reaches a leaf
		  return new Node(data);//The root points to a new node that holds the inputed data
		}
		else if((movieTitle.compareTo(t.key) < 0) && (!movieTitle.equals(t.key))){//If the shortTitle of the inputed data is less
																					//than the shortTitle of the root AND the shortitle of the 
																						//inputed data does not equal the shortitle of the root
			t.left = insertMovie(data, t.left);//Recur to the left

		}else if((movieTitle.compareTo(t.key) > 0) && (!movieTitle.equals(t.key))){//If the shortTitle of the inputed data is less
																						//than the shortTitle of the root AND the shortitle of the 
																							//inputed data does not equal the shortitle of the root
			t.right = insertMovie(data, t.right);//Recur to the right
		}
		return t;//Return the current node
	}

		//This method searches the BST for the inputted key (Movie title)
		private MovieInfo findMovie(Node t, String key) {

		if(t == null){//If the tree is empty or the node reaches a leaf

		return null;//Return null ==> A movie with the entered key does not exist

		}else if(key.compareTo(t.key) < 0){//If the inputed key is less than the key of root
			 return findMovie(t.left, key);//Recur left
		}else if(key.compareTo(t.key) > 0){//If the inputed key is greater than the key of the root
			 return findMovie(t.right, key);//Recur right
		}
		return t.data;//When the key is foudn return the data of the movie
		}

		//This method prints the titles of all the movies that contain the inputted prefix 
		private void printMoviesPrefix(Node t, String prefix) {
			if(t == null){//If the tree is empty or the node reaches a leaf
				return;//Return nothing
			}else{

				String searchPrefix ="";//Initialize variable that will store the inputted prefix without the "*" character

				if(prefix.contains("*")){
				 searchPrefix = prefix.substring(0, prefix.length() - 1);//Sets searchPrefix to the substring from 0 to prefix.length-1 (eliminate "*" character)
			}
				if(t.key.substring(0, searchPrefix.length()).equals(searchPrefix)){//If the characters of root node's key between index 0 and searchPrefix.length() 
																						//EQUAL the inputed prefix
					System.out.println(t.key + " ");//Print the root node's key

				} 
				//If these conditions are not met 
				printMoviesPrefix(t.left, prefix);//Recur left down the BST
				printMoviesPrefix(t.right, prefix);//Recur right down the BST
				
			}

		}

}