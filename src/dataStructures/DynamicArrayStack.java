
package dataStructures;

public class DynamicArrayStack {

	String[] elementsArray = new String[1];
	int index=0;

	public void push (String element) {
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
		elementsArray[index-1] = null;
		index--;
	}

	private static String[] expandArray(String[] original) {
		String[] expandedArray = new String [original.length*2];
		for (int i = 0; i < original.length; i++) {
			expandedArray[i] = original[i];
		}

		return expandedArray;
	}

	private static String[] contractArray(String[] original) {
		String[] contractedArray = new String [original.length/2];

		for (int i = 0; i < contractedArray.length; i++) {
			contractedArray[i] = original[i];
		}

		return contractedArray;
	}

	public void process (String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i)=='-') {
				this.pop();
			}
			else {
				this.push(String.valueOf(command.charAt(i)));
			}
		}
	}
	
	public static void main(String[] args) {
		DynamicArrayStack stack = new DynamicArrayStack();
		
		stack.process("-1-2-34-567-890");
		
		for (int i = 0; stack.elementsArray[i]!=null; i++) {
			System.out.println(stack.elementsArray[i]);
		}
	}
}
