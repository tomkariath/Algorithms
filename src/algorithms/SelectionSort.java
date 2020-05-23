package algorithms;

import java.util.Arrays;

//Find the smallest and swap
public class SelectionSort {
	
	public static void sort(int[] inputArray) {
		int smallestIndex;
		
		for (int i = 0; i < inputArray.length; i++) {
			smallestIndex=i;
			for (int j = i+1; j < inputArray.length; j++) {
				if (inputArray[smallestIndex] > inputArray[j]) {
					smallestIndex = j;
				}
			}
			swap(inputArray, smallestIndex, i);
			//System.out.println(Arrays.toString(inputArray) + " "+inputArray[smallestIndex]);
		}
	}
	
	private static void swap(int[] inputArray, int smallestIndex, int selectedIndex) {
		int temp = inputArray[selectedIndex];
		inputArray[selectedIndex] = inputArray[smallestIndex];
		inputArray[smallestIndex] = temp;
	}
	
	public static void main(String[] args) {
		int[] inputArray = {1,0,2,9,3,8,4,7,5,6};
		SelectionSort.sort(inputArray);
		
		System.out.println(Arrays.toString(inputArray));
	}
}
