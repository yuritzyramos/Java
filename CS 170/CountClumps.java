/*
Problem adapted from CodingBat, https://codingbat.com/java

Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value.
The method countClumps should return the number of clumps in the given array.
However this implementation contains mistakes. Can you fix them?

Examples:
countClumps([1, 2, 2, 3, 4, 4]) should return 2
countClumps([1, 1, 2, 1, 1]) should return 2
countClumps([1, 1, 1, 1, 1]) should return 1
*/

public class CountClumps {

  public static int countClumps(int[] nums) {
    int clumps = 0;
    int i = 1;
    int n = nums.length;
    while (i <= n) {
      int j = i + 1;
      boolean isClump = false;
      while (j < n && nums[i] == nums[j]) {
        isClump = true;
        j++;
      }
      if (!isClump) {
        clumps++;
      }
      i = j;
    }
    return clumps;
  }

  public static void main(String[] args) {
    System.out.println(countClumps(new int[]{1, 2, 2, 3, 4, 4})); // 2
    System.out.println(countClumps(new int[]{1, 1, 2, 1, 1})); // 2
    System.out.println(countClumps(new int[]{1, 1, 1, 1, 1})); // 1
    System.out.println(countClumps(new int[]{1, 2, 3})); // 0
    System.out.println(countClumps(new int[]{2, 2, 1, 1, 1, 2, 1, 1, 2, 2})); // 4
    System.out.println(countClumps(new int[]{0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2})); // 4
    System.out.println(countClumps(new int[]{0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2})); // 5
    System.out.println(countClumps(new int[]{0, 0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2})); // 5
    System.out.println(countClumps(new int[]{})); // 0
  }

}