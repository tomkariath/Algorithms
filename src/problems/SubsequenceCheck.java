package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//p is a subsequence of s if all the letters of p is present in s, in the same relative positions

public class SubsequenceCheck {

    public static void main(String[] args) {
        String input = "globala";
        String sequence = "loaa";

        Map<String, ArrayList<Integer>> indexMap = convertToMap(input);

        System.out.println(isSubsequence(indexMap, sequence));

        for (Map.Entry<String, ArrayList<Integer>> entry : indexMap.entrySet()){
            System.out.println(entry.getKey()+ ":" +entry.getValue());
        }
    }

    private static Map<String, ArrayList<Integer>> convertToMap(String input){
        Map<String, ArrayList<Integer>> indexMap = new HashMap<>();

        for (int i=0; i<input.length(); i++){
            String character = String.valueOf(input.charAt(i));
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

    private static boolean isSubsequence(Map<String, ArrayList<Integer>> indexMap, String sequence){
        boolean isSubsequence = false;
        int previousIndex = -1;

        for (Character letter : sequence.toCharArray()){
            isSubsequence = false;
            ArrayList<Integer> indices = indexMap.get(letter.toString());

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
