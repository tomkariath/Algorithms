package problems;

import edu.princeton.cs.algs4.StdRandom;

public class TimesRepeatingElements {

	public static void main(String[] args) {
		int[] inputArray = { 4, 2, 2, 2, 2, 1, 1, 1, 3, 3, 5, 5 };
		int repeatCount = 4;

		findKTimesRepeatingElement(inputArray, repeatCount);
	}

	private static void findKTimesRepeatingElement(int[] inputArray, int repeatCount) {
		// Shuffling to optimize sort
		StdRandom.shuffle(inputArray);
		// System.out.println(Arrays.toString(inputArray));
		sort(inputArray, repeatCount, 0, inputArray.length - 1);
	}

	private static void sort(int[] inputArray, int repeatCount, int low, int high) {
		// sorting not required
		if (low >= high)
			return;

		// low-lesser[equal]greater-high
		int lesser = low, i = low, greater = high;
		int partitionElement = inputArray[low];

		while (i <= greater) {
			// swap greater until lesser or equal
			if (inputArray[i] > partitionElement) {
				swap(inputArray, i, greater);
				greater--;
			}
			// swap lower and go to next
			else if (inputArray[i] < partitionElement) {
				swap(inputArray, i, lesser);
				lesser++;
				i++;
			}
			// ignore if equal
			else {
				i++;
			}
		}

		/*
		 * System.out.println(partitionElement + Arrays.toString(inputArray));
		 * System.out.println("-------------------------------");
		 */
		//System.out.println(greater - lesser + 1);
		if (greater - lesser >= repeatCount - 1) {
			System.out.println("Result " + partitionElement);
		}

		sort(inputArray, repeatCount, low, lesser - 1);
		sort(inputArray, repeatCount, greater + 1, high);
	}

	private static void swap(int[] inputArray, int firstIndex, int secondIndex) {
		int temp = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[secondIndex];
		inputArray[secondIndex] = temp;
	}
}
