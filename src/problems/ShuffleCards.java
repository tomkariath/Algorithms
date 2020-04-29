package problems;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class ShuffleCards {
	
	//Knuth Shuffle Algorithm
	public static void shuffle(int[] inputArray) {
		int swapIndex;
		for (int i = 0; i < inputArray.length; i++) {
			swapIndex=StdRandom.uniform(inputArray.length);
			swap(inputArray, i, swapIndex);
		}
	}
	
	private static void swap(int[] inputArray, int firstIndex, int secondIndex) {
		int temp = inputArray[secondIndex];
		inputArray[secondIndex] = inputArray[firstIndex];
		inputArray[firstIndex] = temp;
	}
	
	public static void main(String[] args) {
		int[] inputArray = {0,1,2,3,4,5,6,7,8,9};
		ShuffleCards.shuffle(inputArray);
		
		System.out.println(Arrays.toString(inputArray));
	}
}
