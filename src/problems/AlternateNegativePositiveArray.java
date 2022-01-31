package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array return an array where the positive and negative numbers are reordered alternatively while maintaining
 * their respective orders. Fill extra as needed
 *
 * input = [1,-29,3,-44,-5,67,10,2,9,-4,8]
 * output = [1,-29,3,-44,67,-5,10,-4,2,9,8]
 */

public class AlternateNegativePositiveArray {

    static int arrayIndex = 0;

    public static void main(String[] args) {
        //int[] array = {1,29,3,44,5,67, -10,-2,-9,-4,-8};
        int[] array = {1,-29,3,-44,-5,67,10,2,9,-4,8,-9,-3,-2,-87};
       // 1,-29,3,-44,67,-5,10,-4,2,9,8
        System.out.println(Arrays.toString(alternateNegativePositive(array)));
    }

    private static int[] alternateNegativePositive(int[] array){
        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        int[] alternatedArray = new int[array.length];

        splitNegativesAndPositives(array, positiveNumbers, negativeNumbers);

        int minSize = Math.min(positiveNumbers.size(), negativeNumbers.size());

        int positiveIndex = fillAlternatePositives(minSize, alternatedArray, positiveNumbers);
        int negativeIndex = fillAlternateNegatives(minSize, alternatedArray, negativeNumbers);

        if (positiveNumbers.size() > negativeNumbers.size()){
            fillRest(positiveIndex, alternatedArray, positiveNumbers);
        }
        else if (positiveNumbers.size() < negativeNumbers.size()){
            fillRest(negativeIndex, alternatedArray, negativeNumbers);
        }

        return alternatedArray;
    }

    private static void splitNegativesAndPositives (int[]array, List<Integer> positiveNumbers, List<Integer> negativeNumbers){
        for (int number : array){
            if (number>=0){
                positiveNumbers.add(number);
            }
            else {
                negativeNumbers.add(number);
            }
        }
    }

    private static int fillAlternatePositives (int minSize, int[] alternatedArray, List<Integer> positiveNumbers){
        int index =0;

        for(int i=0; index<minSize; i+=2,index++){
            alternatedArray[i] = positiveNumbers.get(index);
        }

        return index;
    }

    private static int fillAlternateNegatives (int minSize, int[] alternatedArray, List<Integer> negativeNumbers){
        int index =0;

        for(arrayIndex=1; index<minSize; arrayIndex+=2,index++){
            alternatedArray[arrayIndex] = negativeNumbers.get(index);
        }

        return index;
    }

    private static void fillRest(int index, int[] alternatedArray, List<Integer> numbers){
        for (int i=index, j=arrayIndex-1; i<numbers.size(); i++,j++){
            alternatedArray[j] = numbers.get(i);
        }
    }
}
