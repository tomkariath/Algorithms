package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Perfect Substrings of a strings are sub strings that has all its elements repeating exactly k time
 * String: 110220120021
 * k=2
 * Perfect substrings
 * 11
 * 110220
 * 22
 * 0220
 * 120021
 */

public class PerfectSubstrings {
    public static void main(String[] args) {
        String string = "110220120021";
        int repeats = 2;

        getPerfectSubstrings(string, repeats);
    }

    private static void getPerfectSubstrings(String string, int repeats){
        Map<Character, Integer> characterCountMap = new HashMap<>();

        for (int left=0; left<string.length(); left++){
            char firstChar = string.charAt(left);
            characterCountMap.put(firstChar, 1);
            String word = String.valueOf(firstChar);

            for (int right=left+1; right<string.length(); right++){
                char newChar = string.charAt(right);
                word = word+newChar;

                if(characterCountMap.get(newChar) !=null){
                    int characterCount = characterCountMap.get(newChar);
                    characterCountMap.put(newChar, characterCount+1);

                    if(characterCount == repeats-1){
                        int status = charCountStatus(characterCountMap, repeats);
                        if (status == 1){
                            System.out.println(word);
                        }
                        else if (status == 2){
                            break;
                        }
                    }
                }
                else {
                    characterCountMap.put(newChar, 1);
                }
            }

            characterCountMap.clear();
        }
    }

    private static int charCountStatus (Map<Character, Integer> characterCountMap, int repeats){
       for (Map.Entry<Character, Integer> entry: characterCountMap.entrySet()){
           if (entry.getValue()<repeats){
               return 0;
           }
           else if (entry.getValue()>repeats){
               return 2;
           }
       }

       return 1;
    }
}
