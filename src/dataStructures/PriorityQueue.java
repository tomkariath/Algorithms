package dataStructures;

import edu.princeton.cs.algs4.StdRandom;

public class PriorityQueue<Item extends Comparable<Item>> extends LLQueue<Item> {
	
	private int size;
	
	public int getSize() {
		return size;
	}

	@Override
	public void enqueue(Item element) {
		super.enqueue(element);
		size ++;
	}

	// dequeue removes smallest element
	public Item dequeue() {
		Item value = null;
		if(head!=null) {
			value = head.element;
			if (head == tail) {
				tail = null;
				head = null;
				size--;
			} else {
				value = dequeue(getSmallestElement());
				size--;
			}
		}
		return value;
	}

	private Item dequeue(Item smallestElement) {
		Item value = null;
		if (head == tail) {
			value = head.element;
			head = tail = null;
		} else if (smallestElement == head.element) {
			value = head.element;
			head = head.nextNode;
		} else {
			Node<Item> previousNode = this.head;

			while (previousNode.getNextNode().element != smallestElement) {
				previousNode = previousNode.getNextNode();
			}

			value = previousNode.getNextNode().element;
			previousNode.setNextNode(previousNode.getNextNode().getNextNode());
		}
		return value;
	}
	
	private Item getSmallestElement() {
		Node<Item> currentNode = this.head;
		Item smallest = currentNode.element;

		while (currentNode != null) {
			if (smallest == null || smallest.compareTo(currentNode.element) > 0) {
				smallest = currentNode.element;
			}
			currentNode = currentNode.getNextNode();
		}
		return smallest;
	}

	@Override
	public void process(String command) {
		super.process(command);
	}

	@Override
	public String toString() {
		StringBuilder queueString = new StringBuilder("[");

		for (Item item : this) {
			queueString.append(item.toString() + ",");
		}

		queueString.deleteCharAt(queueString.length() - 1);
		queueString.append("]");

		return queueString.toString();
	}
	
	public Item getRandomSample() {
		int index = StdRandom.uniform(getSize());

		if (head == tail || index ==0) {
			return head.element;
		}
		else {
			Node<Item> previousNode = this.head;

			for(;index>0;index--) {
				previousNode = previousNode.getNextNode();
			}
		
			return previousNode.element;
		}
	}
	
	public Item dequeueRandom() {
		Item sample = getRandomSample();
		dequeue(sample);
		return sample;
	}

	public static void main(String[] args) {

		PriorityQueue<String> queue = new PriorityQueue<String>();

		queue.process("-1-2-348-569-7-");

		System.out.println(queue);
		
		System.out.println("Size=" + queue.getSize());
		
		System.out.println(queue.getRandomSample());
		
		System.out.println(queue.dequeueRandom());
		System.out.println(queue);
	}
}
