/*
Problem adapted from CodingBat, https://codingbat.com/java

The method lucky13 takes and an array of ints, and should
return true if the array contains no 1's and no 3's.
However this implementation contains mistakes. Can you fix them?

Examples:
lucky13([0, 2, 4]) should return true
lucky13([1, 2, 3]) should return false
lucky13([1, 2, 4]) should return false
*/

public class Lucky13 {

  public static boolean lucky13(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 1 && nums[i] == 3) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(lucky13(new int[]{0, 2, 4})); // true
    System.out.println(lucky13(new int[]{1, 2, 3})); // false
    System.out.println(lucky13(new int[]{1, 2, 4})); // false
    System.out.println(lucky13(new int[]{2, 7, 2, 8})); // true
    System.out.println(lucky13(new int[]{2, 7, 1, 8})); // false
    System.out.println(lucky13(new int[]{3, 7, 2, 8})); // false
    System.out.println(lucky13(new int[]{2, 7, 2, 1})); // false
    System.out.println(lucky13(new int[]{1, 2})); // false
    System.out.println(lucky13(new int[]{2, 2})); // true
    System.out.println(lucky13(new int[]{2})); // true
    System.out.println(lucky13(new int[]{3})); // false
    System.out.println(lucky13(new int[]{})); // true
  }

}