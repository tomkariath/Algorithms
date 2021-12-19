package problems;

import java.util.Arrays;

/**Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N.
 * Find the missing element.
 * Example 1:
 * Input:
 *  N = 5
 *  A[] = {1,2,3,5}
 *  Output: 4
**/

public class MissingNumber {
    public static void main(String[] args) {
        int[] inputArray = {1,2,3,5};
        int sequenceLength = 5;

        int missingNumber = getMissingNumber(inputArray, sequenceLength);

        System.out.println(missingNumber);
    }

    private static int getMissingNumber (int[] inputArray, int sequenceLength){
        return getSequenceSum(sequenceLength) - Arrays.stream(inputArray).sum();
    }

    private static int getSequenceSum (int sequenceLength){
        return (sequenceLength*(sequenceLength+1))/2;
    }
}
