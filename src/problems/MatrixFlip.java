package problems;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given a matrix of size 2n.
 * Give the max sum of the first quadrant of size n.
 * Provided you could flip the rows and columns any number of times to maximise output
 */

public class MatrixFlip {

    public static int getMaxSumOfFirstQuadrant(int[][] matrix){
        int length = matrix.length-1;
        int quadSize = matrix.length/2;
        int sum = 0;

        for (int i=0; i<quadSize; i++){
            for (int j=0; j<quadSize; j++){
                sum += getMax(matrix[i][j], matrix[i][length-j], matrix[length-i][j], matrix[length-i][length-j]);
            }
        }

        return sum;
    }

    private static int getMax(Integer... integers){
        return Collections.max(Arrays.asList(integers));
    }

    public static void main(String[] args) {
        int[][] matrix = {{112, 42, 83, 119},
                {56, 125, 56, 49},
                {15, 78, 101, 43},
                {62, 98, 114, 108}};

        System.out.println(getMaxSumOfFirstQuadrant(matrix));
    }
}
