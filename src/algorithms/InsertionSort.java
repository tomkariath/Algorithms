package algorithms;

import java.util.Arrays;

public class InsertionSort {
	
	public static void sort(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i; j > 0; j--) {
				if (inputArray[j] < inputArray[j-1]) {
					swap(inputArray, j, j-1);
				}
				System.out.println(Arrays.toString(inputArray));
			}
		}
	}
	
	private static void swap(int[] inputArray, int firstIndex, int secondIndex) {
		int temp = inputArray[secondIndex];
		inputArray[secondIndex] = inputArray[firstIndex];
		inputArray[firstIndex] = temp;
	}
	
	public static void main(String[] args) {
		//int[] inputArray = {1,0,2,9,3,8,4,7,5,6};
		//int[] inputArray = {0,1,2,3,4,5,6,7,8,9};
		int[] inputArray = {9,8,7,6,5,4,3,2,1,0};
		InsertionSort.sort(inputArray);
		
		System.out.println(Arrays.toString(inputArray));
	}
}
