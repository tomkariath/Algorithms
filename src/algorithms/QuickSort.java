package algorithms;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	
	public void sort (String[] inputArray) {
		StdRandom.shuffle(inputArray);
		System.out.println(Arrays.toString(inputArray));
		sort(inputArray, 1, inputArray.length-1);
	}

	private void sort (String[] inputArray, int leftEnd, int rightEnd) {
		int splitPosition = partition(inputArray, inputArray[leftEnd-1], leftEnd, rightEnd);
		if (leftEnd < splitPosition-1) {
			System.out.println("Sort Left "+leftEnd+" "+ (splitPosition-1));
			sort(inputArray, leftEnd, splitPosition-1);
		}
		
		if (rightEnd > splitPosition) {
			System.out.println("Sort Right "+(splitPosition+2)+" "+(rightEnd));
			sort(inputArray, splitPosition+2, rightEnd);
		}
	}
	
	private int partition (String[] inputArray, String partitionElement ,int leftEnd, int rightEnd) {
		int partitionElementPosition = leftEnd-1;
		int i = leftEnd, j = rightEnd;
		
		while (i < j) {
			while (i<rightEnd && inputArray[i].compareTo(partitionElement) < 0) {
				System.out.println("left="+inputArray[i]+"<"+partitionElement);
				i++;
			}
			while (j>=leftEnd && inputArray[j].compareTo(partitionElement) >= 0) {
				System.out.println("right="+inputArray[j]+">"+partitionElement);
				j--;
			}
			
			if (i < j) {
				System.out.println("1st Exch "+inputArray[i]+inputArray[j]);
				exchange(inputArray, i, j);
			}
			System.out.println(Arrays.toString(inputArray));
		}
		
		System.out.println("2nd Exch "+inputArray[partitionElementPosition]+" "+inputArray[j]);
		exchange(inputArray, partitionElementPosition, j);
		System.out.println(Arrays.toString(inputArray));
		
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
