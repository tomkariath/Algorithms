package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the number of times an element recurs in an array
 */

public class Recurrence {
    public static void main(String[] args) {
        int[] array = {1,4,7,9,2,2,4,5,7,7,7,9};
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int number : array){
            if (countMap.get(number) == null){
                countMap.put(number, 1);
            }
            else {
                int count = countMap.get(number);
                countMap.put(number, count+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            System.out.println(entry.getKey() +" occurs "+ entry.getValue()+ "times");
        }
    }
}
