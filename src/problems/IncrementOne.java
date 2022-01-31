package problems;

import java.util.Arrays;

/**
 * increment the number represented by the digits in array by one and return as new array
 * inputArray = {9,9,9}
 * output = {1,0,0,0}
 */

public class IncrementOne {
    public static void main(String[] args) {
        int[] array = {9, 9, 9};

        System.out.println(Arrays.toString(incrementOne(array)));
    }

    private static char[] incrementOne(int [] array){
        int number=0;

        for (int i=array.length-1,j=0; i>=0; i--,j++){
            double tens = Math.pow(10,j);
            double digit = tens*array[i];
            number = number + (int)(digit);
        }

        number++;

        return String.valueOf(number).toCharArray();
    }
}
