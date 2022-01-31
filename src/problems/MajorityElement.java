package problems;


import java.util.HashMap;

/**
 * Given an array A of N elements. Find the majority element in the array.
 * A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 * Example 1:
 *
 * Input:
 * N = 3
 * A[] = {1,2,3}
 * Output:
 * -1
 * Explanation:
 * Since, each element in
 * {1,2,3} appears only once so there
 * is no majority element.
 */

public class MajorityElement {
    public static void main(String[] args) {
        int[] inputArray = { 15,16 };

        System.out.println(getMajorityElement(inputArray, inputArray.length));
    }

    private static int getMajorityElement(int[] inputArray, int arraySize){
        if (arraySize == 1){
            return inputArray[0];
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i=0; i<arraySize; i++){
            Integer elementCount = countMap.get(inputArray[i]);
            if (elementCount != null){
                if (elementCount+1 > arraySize/2){
                    return inputArray[i];
                }
                countMap.put(inputArray[i], elementCount+1);
            }
            else {
                countMap.put(inputArray[i], 1);
            }
        }

        return -1;
    }
}
