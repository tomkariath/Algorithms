package algorithms;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		//String[] inputArray = { "a", "r", "u", "v", "i", "l", "i", "b", "e", "r", "t", "y", "s", 
			//	"o", "n", "g" };

		String[] inputArray = {"1","2","3","4","5"};
		
		sort(inputArray);
		
		System.out.println(Arrays.toString(inputArray));
	}

	private static void sort(String[] inputArray) {
		convertToHeap(inputArray);
	}

	private static void convertToHeap(String[] inputArray) {
		for (int i = (inputArray.length/2); i >= 0; i--) {
			sink(inputArray, i);
		}
		System.out.println(Arrays.toString(inputArray));
		for (int length = inputArray.length-1; length >=0; length--) {
			System.out.println(deleteMax(inputArray, length));
		}
	}

	private static String deleteMax(String[] inputArray, int length) {
		if (length == 0) {
			return "zero";
		}
		swap(inputArray, 0, length);

		//sink root
		if (getMaxChild(inputArray, 0, length) != -1 && 
				inputArray[0].compareToIgnoreCase(inputArray[getMaxChild(inputArray, 0, length)]) < 0) {
			sink(inputArray, 0, length);
		}
		return inputArray[length];
	}

	private static void sink(String[] inputArray, int index) {
		int maxChildIndex = getMaxChild(inputArray, index, inputArray.length);
		if (maxChildIndex==-1) {
			return;
		}
		swap(inputArray, index, maxChildIndex);
		index = maxChildIndex;
		if (getMaxChild(inputArray, index, inputArray.length) != -1
				&& inputArray[index].compareToIgnoreCase(
						inputArray[getMaxChild(inputArray, index, inputArray.length)]) < 0) {
			sink(inputArray, index);
		}
	}
	
	private static void sink(String[] inputArray, int index, int length) {
		int maxChildIndex = getMaxChild(inputArray, index, length);
		if (maxChildIndex==-1) {
			return;
		}
		swap(inputArray, index, maxChildIndex);
		index = maxChildIndex;
		if (getMaxChild(inputArray, index, length) != -1
				&& inputArray[index].compareToIgnoreCase(
						inputArray[getMaxChild(inputArray, index, length)]) < 0) {
			sink(inputArray, index);
		}
	}

	private static void swap(String[] inputArray, int firstIndex, int secondIndex) {
		String temp = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[secondIndex];
		inputArray[secondIndex] = temp;
	}

	private static int getMaxChild(String[] inputArray, int index, int length) {
		int child1 = (index) * 2+1;
		int child2 = ((index) * 2)+2;

		if (child1 < length && (child2 >= length
				|| inputArray[child1].compareToIgnoreCase(inputArray[child2]) > 0)) {
			return child1;
		} else if (child2 < length && (child1 >= length
				|| inputArray[child1].compareToIgnoreCase(inputArray[child2]) < 0)) {
			return child2;
		} else {
			return -1;
		}
	}

}
