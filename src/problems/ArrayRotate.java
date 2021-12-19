package problems;

import java.util.Arrays;

/**
 * Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps,
 * where D is a positive integer.
 * Example 1:
 * Input:
 * N = 5, D = 2
 * arr[] = {1,2,3,4,5}
 * Output: 3 4 5 1 2
 * Explanation: 1 2 3 4 5  when rotated
 * by 2 elements, it becomes 3 4 5 1 2.
 */

public class ArrayRotate {

    public static void main(String[] args) {
        int[] inputArray = {2,4,6,8,10,12,14,16,18,20};
        int rotateIndex = 3;
        int arraySize = 10;
        int[] tempArray = Arrays.copyOf(inputArray, rotateIndex);

        int i=0;
        for (; i<(arraySize-rotateIndex); i++){
            inputArray[i] = inputArray[i+rotateIndex];
        }
        for (int j=0; i< arraySize; i++, j++){
            inputArray[i] = tempArray[j];
        }

        System.out.println(Arrays.toString(inputArray));
    }
}
