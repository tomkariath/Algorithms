package algorithms;

import java.util.Arrays;

//Find the smallest and swap
public class SelectionSort {

	private static void doSelectionSort(int[] array){
		int smallestNumber, foundIndex=0;

		for (int i=0; i< array.length-1; i++) {
			smallestNumber = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (smallestNumber > array[j]) {
					smallestNumber = array[j];
					foundIndex = j;
				}
			}

			if (smallestNumber != array[i]) {
				swap(array, i, foundIndex);
			}
		}
	}

	private static void swap(int[] array, int smallIndex, int foundIndex){
		int temp = array[smallIndex];
		array[smallIndex] = array[foundIndex];
		array[foundIndex] = temp;
	}

	public static void main(String[] args) {
		int[] inputArray = {79, 93, 30, 62, 67, 7, 94, 2, 51, 87};
		doSelectionSort(inputArray);

		System.out.println(Arrays.toString(inputArray));
	}
}
