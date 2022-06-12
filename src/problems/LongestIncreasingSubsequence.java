package problems;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    private static Integer[] lis;

    public static void main(String[] args) {
        String input = "604189753";
        lis = new Integer[input.length()];
        Arrays.fill(lis, 1);

        System.out.println(findLIS(input));
    }

    public static int findLIS(String input){
        return findLIS(input.toCharArray());
    }

    private static int findLIS(char[] input){
        for (int i=0; i< input.length; i++){
            for (int j=0; j<i; j++){
                if (input[i]>input[j]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }

        return Collections.max(Arrays.asList(lis));
    }
}
