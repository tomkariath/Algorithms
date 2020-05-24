package problems;

import java.util.Arrays;

public class MergeSortWithSmallerAux {

	static int[] tempArray;

	public static void sort(int[] inputArray) {
		int arrayLength = inputArray.length;
		tempArray = new int[arrayLength / 2];
		
		firstMerge(inputArray, 0, (arrayLength / 2) - 1, arrayLength);
		secondMerge(inputArray, arrayLength / 2, (arrayLength*3 / 4), arrayLength-1);
	}

	//Sort half and shift rest of the elements from first half
	private static void firstMerge(int[] inputArray, int low, int mid, int high) {

		int i = low, j = mid + 1;
		for ( int k = low; k <tempArray.length; k++) {
			if (inputArray[i] < inputArray[j]) {
				tempArray[k] = inputArray[i++];
			} else {
				tempArray[k] = inputArray[j++];
			}
		}

		for (j = mid + 1; i <= mid; i++,j++) {
			inputArray[j] = inputArray[i];
		}

		for (i = low; i <= mid; i++) {
			inputArray[i] = tempArray[i];
		}
	}

	//Sort second half
	private static void secondMerge(int[] inputArray, int low, int mid, int high) {

		for (int i = low, j = mid + 1, k = 0; k < tempArray.length; k++) {
			if (i>mid) {
				tempArray[k] = inputArray[j++];
			}
			else if (j>high) {
				tempArray[k] = inputArray[i++];
			}

			else if (inputArray[i] < inputArray[j]) {
				tempArray[k] = inputArray[i++];
			} else {
				tempArray[k] = inputArray[j++];
			}
		}

		for (int i = low, j=0; j<tempArray.length; i++, j++) {
			inputArray[i] = tempArray[j];
		}
	}

	public static void main(String[] args) {
		//int[] inputArray = { 1, 3, 5, 7, 9, 0, 2, 4, 6, 8 };
		//int[] inputArray = { 5, 6, 7, 8, 9, 0, 1, 2, 3, 4};
		int[] inputArray = {0,1,2,3,4,5,6,7,8,9};
		MergeSortWithSmallerAux.sort(inputArray);

		System.out.println(Arrays.toString(inputArray));
	}
}
