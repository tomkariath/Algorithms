package dataStructures;

public class DynamicSizedArrayStack {

	String[] getElement = new String[1];
	int index=0;

	public void push (String element) {
		if (index==getElement.length-1) {
			getElement = expandArray(getElement);
		}
		getElement[index] =  element;
		index++;
	}

	public void pop() {
		if (index==0) {
			return;
		}
		if (index>0 && index == getElement.length/4) {
			getElement = contractArray(getElement);
		}
		getElement[index-1] = null;
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
		String[] expandedArray = new String [original.length/2];

		for (int i = 0; i < original.length; i++) {
			expandedArray[i] = original[i];
		}

		return expandedArray;
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
		DynamicSizedArrayStack stack = new DynamicSizedArrayStack();
		
		stack.process("-1-2-34-567-890");
		
		for (int i = 0; stack.getElement[i]!=null; i++) {
			System.out.println(stack.getElement[i]);
		}
	}
}
