package algorithms;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSortRepeat {

	public static void main(String[] args) {

		String[] inputArray = { "B", "E", "S", "T", "S", "O", "R", "T", "F", "O", "R", "R", "E", "P", "E", "A", "T",
				"I", "N", "G", "L", "E", "T", "T", "E", "R", "S" };

		// String[] inputArray = {"C","C","C","A","A","A","B","B","B","D","D","D"};

		QuickSortRepeat qs = new QuickSortRepeat();
		qs.sort(inputArray);

		System.out.println(Arrays.toString(inputArray));
	}

	public void sort(String[] inputArray) {
		//Shuffling to optimize sort
		StdRandom.shuffle(inputArray);
		//System.out.println(Arrays.toString(inputArray));
		sort(inputArray, 0, inputArray.length - 1);
	}

	private void sort(String[] inputArray, int low, int high) {
		//sorting not required
		if (low >= high)
			return;

		//low-lesser[equal]greater-high
		int lesser = low, i = low, greater = high;
		String partitionElement = inputArray[low];

		while (i <= greater) {
			//swap greater until lesser or equal
			if (inputArray[i].compareTo(partitionElement) > 0) {
				swap(inputArray, i, greater);
				greater--;
			} 
			//swap lower and go to next
			else if (inputArray[i].compareTo(partitionElement) < 0) {
				swap(inputArray, i, lesser);
				lesser++;
				i++;
			}
			//ignore if equal
			else {
				i++;
			}
		}

		/*
		 * System.out.println(partitionElement + Arrays.toString(inputArray));
		 * System.out.println("-------------------------------");
		 */

		sort(inputArray, low, lesser - 1);
		sort(inputArray, greater + 1, high);
	}

	private void swap(String[] inputArray, int firstIndex, int secondIndex) {
		String temp = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[secondIndex];
		inputArray[secondIndex] = temp;
	}
}
