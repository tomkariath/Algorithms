package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique,
 * or false otherwise.
 */

public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] array = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(array));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        Map<Integer, Integer> uniq = new HashMap<>();

        for (int num : arr){
            occurrences.merge(num, 1, Integer::sum);
        }

        for (int num : occurrences.values()){
            if (uniq.get(num) != null){
                return false;
            }
            uniq.put(num, 1);
        }

        return true;
    }
}
