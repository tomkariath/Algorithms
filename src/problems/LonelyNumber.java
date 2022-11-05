package problems;

import java.util.HashMap;
import java.util.Map;

public class LonelyNumber {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,3,2,1};

        Map<Integer, Integer> duplicateMap = new HashMap<>();

        for (int digit: input) {
            if (duplicateMap.get(digit) == null){
                duplicateMap.put(digit,1);
            }
            else {
                duplicateMap.put(digit, 2);
            }
        }

        for (Map.Entry<Integer, Integer> entry : duplicateMap.entrySet()){
            if (entry.getValue() == 1){
                System.out.println(entry.getKey());
            }
        }
    }
}
