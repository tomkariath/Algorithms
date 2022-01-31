package problems;

import java.util.Arrays;

/**
 * Given an index get rotate an array from that index
 * array = [1,2,3,4,5], index = 2
 *  rotated array = [3,4,5,1,2]
 *
 */

public class RotateArray {

    public static void main(String[] args) {
        int reverseIndex = 20;
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(Arrays.toString(rotateArray(array, reverseIndex)));
    }

    private static int[] rotateArray(int[] array, int index) {
        int length = array.length;

        if (index < 1 || index>length){
            return array;
        }
        int rotatedIndex = length - index;
        int[] rotatedArray = new int[length];

        for (int i = index, j = 0; i < length; i++, j++) {
            rotatedArray[j] = array[i];
        }

        for (int i = rotatedIndex, j = 0; i < length; i++, j++) {
            rotatedArray[i] = array[j];
        }

        return rotatedArray;
    }
}
