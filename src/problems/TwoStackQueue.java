package problems;

import dataStructures.LLStack;

public class TwoStackQueue {

	LLStack<Integer> dataStack = new LLStack<Integer>();
	LLStack<Integer> queueStack = new LLStack<Integer>();
	int size;
	
	public void enQueue (int item) {
		dataStack.push(item);
		size++;
	}
	
	public Integer deQueue () {
		if (queueStack.getSize()==0) {
			while(dataStack.getSize()!=0) {
				queueStack.push(dataStack.pop());
			}
		}
		size--;
		return queueStack.pop();
	}
	
	private static void process (TwoStackQueue queue, String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i)=='-') {
				queue.deQueue();
			}
			else {
				queue.enQueue(Character.getNumericValue(command.charAt(i)));
			}
		}
	}
	
	public static void main(String[] args) {
		TwoStackQueue queue = new TwoStackQueue();
		
		process(queue, "1-2-34-567");
		
		while (queue.size>0) {
			System.out.println(queue.deQueue());
		}
	}
}
