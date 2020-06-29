package algorithms;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	public void sort(String[] inputArray) {
		StdRandom.shuffle(inputArray);
		sort(inputArray, 0, inputArray.length - 1);
	}

	private void sort(String[] inputArray, int leftEnd, int rightEnd) {
		int splitPosition = partition(inputArray, leftEnd, rightEnd);
		//sort left
		if (leftEnd<splitPosition-1){
			sort(inputArray, leftEnd, splitPosition-1);
		}
		//sort right
		if (splitPosition+1<rightEnd)
			sort(inputArray, splitPosition+1, rightEnd);
	}

	private int partition(String[] inputArray, int leftEnd, int rightEnd) {
		
		String partitionElement = inputArray[leftEnd];
		int i=leftEnd+1, j=rightEnd;
		
		while (i<j) {
			while (inputArray[i].compareTo(partitionElement)<=0 && i<rightEnd) {
				i++;
			}
			
			while (inputArray[j].compareTo(partitionElement)>0) {
				j--;
			}
			
			if (i < j) {
				exchange(inputArray, i, j);
			}
		}
		
		if (partitionElement.compareTo(inputArray[j])>0){
			exchange(inputArray, leftEnd, j);
		}
		
		return j;
	}
	
	private void exchange (String[] inputArray, int firstPosition, int secondPosition) {
		String tempString = inputArray[firstPosition];
		inputArray[firstPosition] = inputArray[secondPosition];
		inputArray[secondPosition] = tempString;
	}
	
	public static void main(String[] args) {
		String[] inputArray = {"Q","U","I","C","K","S","O","R","T"};
		
		QuickSort qs = new QuickSort();
		qs.sort(inputArray);
		
		System.out.println(Arrays.toString(inputArray));
	}
}
