package dataStructures;

public class DynamicArrayQueue {

	String[] elementsArray = new String[1];
	int head=0, tail=0;
	
	private void enqueue (String element) {
		if (tail==elementsArray.length-1) {
			elementsArray = expandArray(elementsArray);
		}
		elementsArray[tail]=element;
		tail++;
	}
	
	private void dequeue () {		
		if (tail>0 && tail-head == elementsArray.length/4) {
			elementsArray = contractArray(elementsArray);
		}
		
		if (head==tail) {
			elementsArray[head]=null;
			head=tail=0;
		}
		else {
			head++;
		}
	}
	
	private String[] expandArray(String[] original) {
		String[] expandedArray = new String [original.length*2];
		for (int i = 0; i < original.length; i++) {
			expandedArray[i] = original[i];
		}

		return expandedArray;
	}
	
	private String[] contractArray(String[] original) {
		String[] contractedArray = new String [original.length/2];

		for (int i=this.head, j=0; i < this.tail; i++, j++) {
			contractedArray[j] = original[i];
		}
		this.tail = this.tail-this.head;
		this.head = 0;
		
		return contractedArray;
	}

	private void process (String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i)=='-') {
				this.dequeue();
			}
			else {
				this.enqueue(String.valueOf(command.charAt(i)));
			}
		}
	}
	
	public static void main(String[] args) {
		DynamicArrayQueue queue = new DynamicArrayQueue();
		
		queue.process("-1-2-348-569-7");
		
		for (int i = queue.head; i<=queue.tail && queue.elementsArray[i]!=null; i++) {
			System.out.println(queue.elementsArray[i]);
		}
	}
}
