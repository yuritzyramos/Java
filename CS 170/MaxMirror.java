/*
Problem adapted from CodingBat, https://codingbat.com/java

We'll say that a "mirror" section in an array is a group of contiguous elements
such that somewhere in the array, the same group appears in reverse order.
For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3
(the {1, 2, 3} part). The method maxMirror should return the size of the largest
mirror section found in the given array.
However this implementation contains mistakes. Can you fix them?
Hint: test and debug the two auxiliary methods mirror() and find() by themselves first.

Examples:
maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) should return 3
maxMirror([1, 2, 1, 4]) should return 3
maxMirror([7, 1, 2, 9, 7, 2, 1]) should return 2
*/

public class MaxMirror {

  public static int maxMirror(int[] nums) {
    int n = nums.length;
    while (n > 0) {
      for (int i = 0; i <= nums.length - n; i++) {
        int[] m = mirror(nums, i, i + n);
        if (find(m, nums)) {
          return n; // change return i to return n to get the length otherwise you will get the index of 
        }
      }
      n--;
    }
    return 0;
  }

  // This method returns a new array containing a mirrored copy
  // of a sub-array x from index start (included) and end (excluded).
  // Example:
  // mirror({3, 4, 5, 6, 7, 8}, 1, 4) returns {6, 5, 4}
  public static int[] mirror(int[] x, int start, int end) {
    int[] result = new int[end - start];
    for (int i = 0; i < result.length; i++) {
      result[i] = x[end - i -1]; //add -1 bc the end is excluded 
    }
    return result;
  }

  // This method checks if a sub-array x is contained in array y.
  // Examples:
  // find({1, 2, 3}, {3, 4, 1, 2, 3}) returns true
  // find({1, 2, 3}, {3, 4, 1, 2}) returns false
  public static boolean find(int[] x, int[] y) {
    boolean result = false;
    int i = 0;
    while (i + x.length <= y.length) {
      boolean match = true; // initialize variable match; 
      for (int j = 0; j < x.length; j++) {
        if (x[j] != y[i + j]) {
          match = false;
        }  
        ///remove else branch because you already have a statement accounting for true
        }
      if (match) {
        return true;
      }
      i++;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1})); // 3	
    System.out.println(maxMirror(new int[]{1, 2, 1, 4})); // 3	
    System.out.println(maxMirror(new int[]{7, 1, 2, 9, 7, 2, 1})); // 2	
    System.out.println(maxMirror(new int[]{21, 22, 9, 8, 7, 6, 23, 24, 6, 7, 8, 9, 25, 7, 8, 9})); // 4	
    System.out.println(maxMirror(new int[]{1, 2, 1, 20, 21, 1, 2, 1, 2, 23, 24, 2, 1, 2, 1, 25})); // 4	
    System.out.println(maxMirror(new int[]{1, 2, 3, 2, 1})); // 5	
    System.out.println(maxMirror(new int[]{1, 2, 3, 3, 8})); // 2	
    System.out.println(maxMirror(new int[]{1, 2, 7, 8, 1, 7, 2})); // 2	
    System.out.println(maxMirror(new int[]{1, 1, 1})); // 3	
    System.out.println(maxMirror(new int[]{1})); // 1	
    System.out.println(maxMirror(new int[]{})); // 0	
    System.out.println(maxMirror(new int[]{9, 1, 1, 4, 2, 1, 1, 1})); // 3	
    System.out.println(maxMirror(new int[]{5, 9, 9, 4, 5, 4, 9, 9, 2})); // 7	
    System.out.println(maxMirror(new int[]{5, 9, 9, 6, 5, 4, 9, 9, 2})); // 2	
    System.out.println(maxMirror(new int[]{5, 9, 1, 6, 5, 4, 1, 9, 5})); // 3
  }

}