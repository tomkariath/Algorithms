package algorithms;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort2 {
	public void sort(String[] inputArray) {
		StdRandom.shuffle(inputArray);
		System.out.println(Arrays.toString(inputArray));
		sort(inputArray, 0, inputArray.length - 1);
	}

	private void sort(String[] inputArray, int leftEnd, int rightEnd) {
		int splitPosition = partition(inputArray, leftEnd, rightEnd);
		//sort left
		System.out.println("Sort Left "+leftEnd+" "+ (splitPosition-1));
		if (leftEnd<splitPosition-1){
			sort(inputArray, leftEnd, splitPosition-1);
		}
		//sort right
		System.out.println("Sort Right "+(splitPosition+1)+" "+rightEnd);
		if (splitPosition+1<rightEnd)
			sort(inputArray, splitPosition+1, rightEnd);
	}

	private int partition(String[] inputArray, int leftEnd, int rightEnd) {
		
		String partitionElement = inputArray[leftEnd];
		int i=leftEnd+1, j=rightEnd;
		
		while (i<j) {
			//System.out.println("Values "+i+j);
			while (inputArray[i].compareTo(partitionElement)<=0 && i<rightEnd) {
				System.out.println("left="+inputArray[i]+"<"+partitionElement);
				i++;
			}
			
			while (inputArray[j].compareTo(partitionElement)>0) {
				System.out.println("right="+inputArray[j]+">"+partitionElement);
				j--;
			}
			
			if (i < j) {
				System.out.println("1st Exch "+inputArray[i]+inputArray[j]);
				exchange(inputArray, i, j);
			}
		}
		
		if (inputArray[leftEnd].compareTo(inputArray[j])>0){
			System.out.println("2nd Exch "+inputArray[leftEnd]+" "+inputArray[j]+i+j);
			exchange(inputArray, leftEnd, j);
		}
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
		
		QuickSort2 qs = new QuickSort2();
		qs.sort(inputArray);
		
		System.out.println(Arrays.toString(inputArray));
	}
}
