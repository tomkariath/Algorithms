package problems;

import java.util.Arrays;

public class MaxElementStack {

	private int[] elementsArray = new int[1];
	private int index=0, maxElement=0;

	public void push (int element) {
		if (element>maxElement) {
			maxElement = element;
		}
		if (index==elementsArray.length-1) {
			elementsArray = expandArray(elementsArray);
		}
		elementsArray[index] =  element;
		index++;
	}

	public void pop() {
		if (index==0) {
			return;
		}
		if (index>0 && index == elementsArray.length/4) {
			elementsArray = contractArray(elementsArray);
		}
		if (elementsArray[index-1]==maxElement) {
			elementsArray[index-1] = 0;
			maxElement=findNewMax();
		}
		else {
			elementsArray[index-1] = 0;
		}
		index--;
	}
	
	private int findNewMax() {
		return Arrays.stream(elementsArray).max().getAsInt();
	}

	private static int[] expandArray(int[] original) {
		int[] expandedArray = new int [original.length*2];
		for (int i = 0; i < original.length; i++) {
			expandedArray[i] = original[i];
		}

		return expandedArray;
	}


	private static int[] contractArray(int[] original) {
		int[] contractedArray = new int [original.length/2];

		for (int i = 0; i < contractedArray.length; i++) {
			contractedArray[i] = original[i];
		}

		return contractedArray;
	}
	
	public int getMaxElement() {
		return maxElement;
	}
	
	public int getElement(int index) {
		return this.elementsArray[index];
	}

	public void process (String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i)=='-') {
				this.pop();
			}
			else {
				this.push(Character.getNumericValue(command.charAt(i)));
			}
		}
	}
	
	public static void main(String[] args) {
		MaxElementStack stack = new MaxElementStack();
		
		stack.process("-1-2-349-567-8");
		
		for (int i = 0; stack.getElement(i)!=0; i++) {
			System.out.println(stack.getElement(i));
		}
		
		System.out.println("MaxElement: "+ stack.getMaxElement());
	}
}
