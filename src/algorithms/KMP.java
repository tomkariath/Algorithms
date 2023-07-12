package algorithms;

import java.util.Arrays;

public class KMP {

    public static void main(String[] args) {
        //String text = "abxabcabcaby";
        String text = "aabaacaadaabaaba";
        //String pattern = ("abcaby");
        String pattern = ("aaba");

        findPattern(text, pattern);
    }

    public static void findPattern(String text, String pattern){
        int[] prefixIndices =getPrefixIndicesForPattern(pattern);
        Arrays.stream(prefixIndices).forEach(System.out :: println);

        for (int i=0, j=0; i<text.length();){
            if (text.charAt(i) == pattern.charAt(j)){
                if (j==pattern.length()-1){
                    i=i-j+1;
                    j=0;
                    System.out.println("Found Occurrence at " + (i-1));
                    continue;
                }
                i++;
                j++;
            }
            else {
                if (j==0){
                    i++;
                } else {
                    j=prefixIndices[j-1];
                }
            }
        }
    }

    private static int[] getPrefixIndicesForPattern(String pattern){
        int[] prefixIndices = new int[pattern.length()];
        for (int i=0, j=-1; i<pattern.length(); ){
            if (i==0 || pattern.charAt(i) == pattern.charAt(j)){
                prefixIndices[i++] = ++j;
            }
            else {
                if (j==0){
                    prefixIndices[i++] = 0;
                }
                else {
                    j = prefixIndices[j-1];
                }
            }
        }

        return prefixIndices;
    }
}
