package algorithms;

import java.util.Arrays;

public class BottomUpMergeSort {
	static int[] tempArray;

	public static void sort (int[] inputArray) {
		tempArray = new int[inputArray.length];

		for (int width = 1; width < inputArray.length; width *= 2) {
			System.out.println("-------------------------");
			System.out.println(width);
			for (int i = 0; i < inputArray.length; i=i+2*width) {
				int low = i;
				int high = Math.min((i+2*width),tempArray.length)-1;
				int mid = i+width-1;
				merge(inputArray, low, mid, high);
			}
		}
	}

	private static void merge (int[] inputArray, int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			tempArray[i] = inputArray[i];
		}

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
		System.out.println("Input: "+ Arrays.toString(inputArray));
	}

	public static void main(String[] args) {
		//int[] inputArray = {1,0,2,9,3,8,4,7,5,6};
		//int[] inputArray = {0,1,2,3,4,5,6,7,8,9};
		int[] inputArray = {9,8,7,6,5,4,3,2,1,0};
		BottomUpMergeSort.sort(inputArray);

		System.out.println(Arrays.toString(inputArray));
	}
}
