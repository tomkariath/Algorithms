package dataStructures;

public class ResizingArray<Type extends Comparable<Type>> {
	private Type[] array;
	private int length;
	
	@SuppressWarnings("unchecked")
	public ResizingArray() {
		array = (Type[]) new Comparable[1];
		length =0;
	}
	
	public void put(int index, Type value) {
		if (this.length==array.length-1) {
			array = expandArray(array);
		}
		array[index] =  value;
	}
	
	public void put(Type value) {
		if (this.length==array.length-1) {
			array = expandArray(array);
		}
		array[length] =  value;
		this.length++;
	}
	
	public Type get(int index) {
		return array[index];
	}

	@SuppressWarnings("unchecked")
	private Type[] expandArray(Type[] original) {
		Type[] expandedArray = (Type[]) new Comparable [original.length*2];
		for (int i = 0; i < original.length; i++) {
			expandedArray[i] = original[i];
		}

		return expandedArray;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		StringBuilder queueString = new StringBuilder("[");

		for (int i=0; i < this.getLength(); i++) {
			queueString.append(this.array[i].toString() + ",");
		}

		if (queueString.charAt(queueString.length() - 1)==',') {
			queueString.deleteCharAt(queueString.length() - 1);
		}
		queueString.append("]");

		return queueString.toString();
	}
}
