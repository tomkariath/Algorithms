package algorithms;

import java.util.Arrays;

//insertion sort over a specified gap that widens (ideally 3*gap+1)
public class ShellSort {

	public static void sort(int[] inputArray) {
		int hGap = 1;
		while (hGap < inputArray.length / 3) {
			hGap = 3 * hGap + 1;
		}
		while (hGap > 0) {
			for (int i = hGap; i < inputArray.length; i++) {
				for (int j = i; j - hGap >= 0; j -= hGap) {
					if (inputArray[j] < inputArray[j - hGap]) {
						swap(inputArray, j, j - hGap);
					}
					//System.out.println(Arrays.toString(inputArray) + "h=" + hGap);
				}
			}
			hGap /= 3;
		}
	}

	private static void swap(int[] inputArray, int firstIndex, int secondIndex) {
		int temp = inputArray[secondIndex];
		inputArray[secondIndex] = inputArray[firstIndex];
		inputArray[firstIndex] = temp;
	}

	public static void main(String[] args) {
		int[] inputArray = {1,0,2,9,3,8,4,7,5,6};
		//int[] inputArray = {0,1,2,3,4,5,6,7,8,9};
		//int[] inputArray = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		ShellSort.sort(inputArray);

		System.out.println(Arrays.toString(inputArray));
	}
}
