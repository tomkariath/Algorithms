package problems;

import dataStructures.BinaryHeap;

public class FindMedian {

	private BinaryHeap heap = new BinaryHeap();
	
	public void insert(String value) {
		heap.insert(value);
	}
	
	public String getMedian() {
		int size = heap.getSize()/2;
		String[] temp = new String[size];
		
		for (int i = 0; i < size; i++) {
			temp[i] = heap.deleteMax();
		}
		String max = heap.getMax();
	
		for (String string : temp) {
			heap.insert(string);
		}
		
		return max;
	}
	
	public String removeMedian() {
		int size = heap.getSize()/2;
		String[] temp = new String[size];
		
		for (int i = 0; i < size; i++) {
			temp[i] = heap.deleteMax();
		}
		String max = heap.deleteMax();
	
		for (String string : temp) {
			heap.insert(string);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		FindMedian findMedian = new FindMedian();
		String input = "123456";
		for (Character ch : input.toCharArray()) {
			findMedian.insert(ch.toString());
		}
		
		System.out.println(findMedian.getMedian());
		System.out.println(findMedian.removeMedian());
		System.out.println(findMedian.getMedian());
	}
}
