package algorithms;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSelect {

	public static void main(String[] args) {

		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		QuickSelect qs = new QuickSelect();

		System.out.println(qs.select(inputArray, 2));
	}

	public int select(int[] inputArray, int index) {
		int low = 0;
		int high = inputArray.length - 1;

		StdRandom.shuffle(inputArray);

		return select(inputArray, low, high, index);
	}

	private int select(int[] inputArray, int low, int high, int index) {
		int partitionElement = inputArray[low];
		int i = low + 1;
		int j = high;
		System.out.println(Arrays.toString(inputArray) + low + high);

		while (i<j) {
			while (inputArray[i]<partitionElement && i<high) {
				System.out.println("i= "+inputArray[i]+" < "+partitionElement);
				i++;
			}
			while (inputArray[j]>partitionElement) {
				System.out.println("j= "+inputArray[j]+" > "+partitionElement);
				j--;
			}
			if(i<j) {
				swap(inputArray, i, j);
				System.out.println(Arrays.toString(inputArray));
			}
		}
		
		if (partitionElement > inputArray[j]) {
			swap(inputArray, low, j);
		}
		
		System.out.println(inputArray[j]+ " "+ (j+1));
		System.out.println("-----------------------");
		if (j+1 == index) {
			return inputArray[j];
		}
		else if (index>j+1){
			return select(inputArray, j+1, high, index);
		}
		else {
			return select(inputArray, low, j-1, index);
		}
	}
	
	private void swap (int[] inputArray, int firstPosition, int secondPosition) {
		int tempString = inputArray[firstPosition];
		inputArray[firstPosition] = inputArray[secondPosition];
		inputArray[secondPosition] = tempString;
	}
}
