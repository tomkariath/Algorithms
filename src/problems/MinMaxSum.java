package problems;

import java.util.*;


public class MinMaxSum {

    // max sum of 4 out of 5 elements
    public static long findMaxSum (List<Integer> input){
        long sum = 0;

        //number of entries is 5
        for (int i=4; i>0; i--){
            sum = sum + input.get(i);
        }

        return sum;
    }
    // min sum of 4 out of 5 elements
    public static long findMinSum (List<Integer> input){
        long sum = 0;

        //number of entries is 5
        for (int i=0; i<4; i++){
            sum = sum + input.get(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(254961783, 604179258, 462517083, 967304281, 860273491);


        Collections.sort(input);

        System.out.println(findMaxSum(input));
        System.out.println(findMinSum(input));
    }
}
