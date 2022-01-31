package problems;

import java.util.Arrays;

/**
 * Given an array return an array such that the numbers are replaced by the products of all the other elements
 */

public class ProductArray {
    public static void main(String[] args) {
        int[] array = {1,2,3};

        int product = Arrays.stream(array).reduce(1, (a, b) -> a*b);

        for (int i =0; i< array.length; i++){
            if (array[i] != 0){
                array[i] = product/array[i];
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
