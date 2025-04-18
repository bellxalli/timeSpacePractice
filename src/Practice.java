import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {

  // Time Complexity: o(n) n is array size
  // Space Complexity: o(n) n is new list
  public static List<Integer> findEvens(int[] array) {
    List<Integer> evens = new ArrayList<>();
    for (int num : array) {
      if (num % 2 == 0) {
        evens.add(num);
      }
    }
    return evens;
  }

  // Time Complexity: o(n) n is matrix length
  // Space Complexity: o(1)
  public static int sumDiagonal(int[][] matrix) {
    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      sum += matrix[i][i];
    }
    return sum;
  }
  
//n = T
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  // Does the 'T' look confusing? Consider refreshing on generic methods
  // We'll revisit generics as a class later
  public static <T> Map<T, Integer> countFrequencies(T[] array) {
    HashMap<T, Integer> frequencies = new HashMap<>();
    for (T val : array) {
      frequencies.put(val, frequencies.getOrDefault(val, 0) + 1);
    }
    return frequencies;
  }

//n = n*n
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public static List<Integer> evensToSquare(int n) {
    List<Integer> evens = new ArrayList<>();
    for(int i = 0; i <= n*n; i+=2) {
      evens.add(i);
    }
    return evens;
  }

  /**
   * Returns the integer that shows up most frequently in an array.
   * If there is a tie, tiebreak by returning the one that shows up first
   * in the array.
   * 
   * THIS METHOD MUST RUN IN O(n) TIME. n = nums.size()
   * 
   * Once you finish, WRITE TESTS FOR IT in PracticeTest.java
   * 
   * Time Complexity: O(n)
   * Space Complexity: O(n) (potentially n number of entries)
   * 
   * @param nums An array of integers
   * @return the integer that shows up most commonly
   */
  public static int mostCommonTimeEfficient(int[] nums) {
    // TODO: Complete this method with an implementation that runs
    // in O(n) time. n = nums.size()

  Map<Integer, Integer> mapOfCommonNums = new HashMap<>();
    int maxCount = 0;
      int mostCommon = nums[0];

    // Loop through the array and count how many times a number is read through
    for (int commonNumber : nums) {
      mapOfCommonNums.put(commonNumber, mapOfCommonNums.getOrDefault(commonNumber,0)+ 1 );
       // checks if the common number is greater than the maxCount and then sets it to mostCommon
        if (mapOfCommonNums.get(commonNumber) > maxCount) {
          maxCount = mapOfCommonNums.get(commonNumber);
          mostCommon = commonNumber;
       }//end if
     }//end for
     
     return mostCommon;
   }//end mostCommonTimeEfficient

  /**
   * Returns the integer that shows up most frequently in an array.
   * If there is a tie, tiebreak by returning the one that shows up first
   * in the array.
   * 
   * THIS METHOD MUST USE ONLY O(1) SPACE.
   * 
   * Once you finish, WRITE TESTS FOR IT in PracticeTest.java
   * 
   * Time Complexity: 
   * Space Complexity: o(1)
   * 
   * @param nums An array of integers
   * @return the integer that shows up most commonly
   */
  public static int mostCommonSpaceEfficient(int[] nums) {
    // TODO: Complete this method with an implementation that runs
    // in O(1) space.

    //empty array
    if(nums.length == 0)
      return -1;

    int count = 0;
    int possibleNum = 0;

    //finding the num that shows up most (tiebreaker built in)  
    for(int i = nums.length-1; i >= 0; i--)
    {
      if(count == 0) //starting number and finding recurring num
        possibleNum = nums[i];
      if(nums[i] == possibleNum) //checking if num[i] value has already appeared, ++
        count ++;
      if(nums[i] != possibleNum) //if it hasn't appeared then --
        count--;
    }
   
    return possibleNum;
  }
}