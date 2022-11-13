package problems;

import java.util.Arrays;

public class TwoSumSorted {

    public static int[] findTwoSum(int[] sortedArray, int target){
        int firstIndex=0;
        int secondIndex=sortedArray.length-1;
        int tempSum=0;

        while (secondIndex > firstIndex) {
            tempSum = sortedArray[firstIndex]+sortedArray[secondIndex];
            if(tempSum == target){
                return new int[]{firstIndex, secondIndex};
            }
            if (tempSum > target){
                secondIndex--;
            }
            else {
                firstIndex++;
            }
        }

        return new int[]{-1, -1};

    }

    public static void main(String[] args) {
        int[] sortedArray = {-2, -1, 1, 3, 5, 9};
        int target = 1;

        System.out.println(Arrays.toString(findTwoSum(sortedArray, target)));
    }
}
