package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxDeleteRetainSubsequence {
    public static void main(String[] args) {
        String input = "globalcontactlessdebitcard";
        String sequence = "goaa";
       // int[] deletions = {0,3,1,4,5,9,2};
        //int[] deletions = {3,0,1,4,5,9,2};
       // int[] deletions = {3,1,4,0,5,9,2};
     //   int[] deletions = {3,1,4,5,0,9,2};
     //   int[] deletions = {3,1,4,5,9,0,2};
        int[] deletions = {3,1,4,5,9,2};

        Map<Character, ArrayList<Integer>> indexMap = convertToCharacterMap(input);

        System.out.println(binaryProcessing(input, indexMap, sequence, deletions));
    }

    private static int binaryProcessing(String input, Map<Character, ArrayList<Integer>> indexMap,
                                    String sequence, int[] deletions){
        int left =0, right = deletions.length, maxDeletions = 0, mid;

        while (left<right){
            if ((left+right)%2!=0){
                mid = (left+right+1)/2;
            }
            else {
                mid = (left+right)/2;
            }

            int[] subDeletions = Arrays.copyOfRange(deletions, left, mid);

            int maxSubDeletions = getMaxDeletionsWhileRetainingSubsequence(input, indexMap, sequence, subDeletions);

            maxDeletions = maxDeletions+maxSubDeletions;

            if (maxSubDeletions == subDeletions.length){
                left = mid;
            }
            else {
                break;
            }
        }

        return maxDeletions;
    }


    private static Map<Character, ArrayList<Integer>> convertToCharacterMap(String input){
        Map<Character, ArrayList<Integer>> indexMap = new HashMap<>();

        for (int i=0; i<input.length(); i++){
            Character character = input.charAt(i);
            if (indexMap.get(character)==null){
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                indexMap.put(character, indices);
            }
            else {
                indexMap.get(character).add(i);
            }
        }
        return indexMap;
    }

    private static int getMaxDeletionsWhileRetainingSubsequence(String input, Map<Character, ArrayList<Integer>> indexMap,
                                                                String sequence, int[] deletions){
        int count = 0;

        for (int index : deletions){
            Character letter = input.charAt(index);

            ArrayList indices = indexMap.get(letter);
            indices.remove(Integer.valueOf(index));

            if (isSubsequence(indexMap, sequence)){
                count++;
            }
            else {
                break;
            }
        }

        return count;
    }

    private static boolean isSubsequence(Map<Character, ArrayList<Integer>> indexMap, String sequence){
        boolean isSubsequence = false;
        int previousIndex = -1;

        for (Character letter : sequence.toCharArray()){
            isSubsequence = false;
            ArrayList<Integer> indices = indexMap.get(letter);

            if (indices != null){
                for (int index : indices){
                    if (index > previousIndex){
                        isSubsequence = true;
                        previousIndex = index;
                        break;
                    }
                }

                if (!isSubsequence){
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return isSubsequence;
    }
}
