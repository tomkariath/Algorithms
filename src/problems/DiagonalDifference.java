package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {

    public static int diagonalDifference (List<List<Integer>> matrix){
        int length = matrix.size();
        int primarySum = 0;
        int secondarySum = 0;

        for (int i=0, j=length-1; i<length; i++, j--){
            primarySum = primarySum + matrix.get(i).get(i);
            secondarySum = secondarySum + matrix.get(i).get(j);
        }

        return Math.abs(primarySum - secondarySum);
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(Arrays.asList(1,2,5), Arrays.asList(1,2,3), Arrays.asList(1,2,4));

        System.out.println(diagonalDifference(matrix));
    }
}
