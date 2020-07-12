package problems;

import dataStructures.PriorityQueue;

public class NLargestElements {

	public static void main(String[] args) {
		Integer[] inputArray = {7,6,2,3,1,5,4,8,9};
		Integer count = 5;
		
		System.out.println(getLargestN(inputArray, count));
	}

	private static PriorityQueue<Integer> getLargestN(Integer[] inputArray, Integer count) {
		PriorityQueue<Integer> largestQueue = new PriorityQueue<Integer>();
		
		for (Integer integer : inputArray) {
			largestQueue.enqueue(integer);
			if (count>0) {
				count--;
			}
			else {
				largestQueue.dequeue();
			}
		}
		
		return largestQueue;
	}
	
}
