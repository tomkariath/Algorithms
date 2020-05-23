package algorithms;

import java.util.Arrays;

//Sort by recursively merging halves
public class MergeSort {
	static int[] tempArray;

	public static void sort (int[] inputArray) {
		tempArray = new int[inputArray.length];
		sort(inputArray, tempArray, 0, inputArray.length-1);
	}

	private static void sort(int[] inputArray, int[] tempArray, int low, int high) {
		if (high<=low) {
			return;
		}

		int mid = low +(high-low)/2;
		sort(inputArray, tempArray, low, mid);
		sort(inputArray, tempArray, mid+1, high);
		merge(inputArray, tempArray, low, mid, high);
	}

	private static void merge (int[] inputArray, int[] tempArray, int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			tempArray[i] = inputArray[i];
		}
		System.out.println(Arrays.toString(tempArray));

		int i=low, j=mid+1;
		for (int k = low; k <= high; k++) {
			if (i>mid) {
				inputArray[k] = tempArray[j++];
			}
			else if (j>high) {
				inputArray[k] = tempArray[i++];
			}
			else if (tempArray[i]<tempArray[j]) {
				inputArray[k] = tempArray[i++];
			}
			else {
				inputArray[k] = tempArray[j++];
			}
		}
	}

	public static void main(String[] args) {
		//int[] inputArray = {1,0,2,9,3,8,4,7,5,6};
		//int[] inputArray = {0,1,2,3,4,5,6,7,8,9};
		int[] inputArray = {9,8,7,6,5,4,3,2,1,0};
		MergeSort.sort(inputArray);

		System.out.println(Arrays.toString(inputArray));
	}
}
