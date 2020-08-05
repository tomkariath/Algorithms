package dataStructures;

import java.util.Iterator;

public class LLQueue<Item extends Comparable<Item>> implements Iterable<Item>{
	
	private class ListIterator implements Iterator<Item>{
		
		Node<Item> currentNode = head;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public Item next() {
			Item item = currentNode.element;
			currentNode = currentNode.nextNode;
			return item;
		}
		
	}
	
	Node<Item> head, tail;
	int size=0;
	
	public int getSize() {
		return size;
	}
	
	public void enqueue(Item element) {
		if (head==null && tail==null) {
			head = new Node<Item>(element);
			tail = head;
		}
		else {
			Node<Item> newNode = new Node<Item>(element);
			if (head!=tail) {
				tail.nextNode=newNode;
				tail=newNode;
			}
			else {
				tail=newNode;
				head.nextNode=tail;
			}
		}
		size++;
	}
	
	public Item dequeue() {
		Item value = null;
		if(head!=null) {
			value = head.element;
			if(head==tail) {
				tail=null;
				head=null;
			}
			else {
				head = head.nextNode;
			}
			size--;
		}
		return value;
	}
	
	@SuppressWarnings("unchecked")
	public void process (String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i)=='-') {
				this.dequeue();
			}
			else {
				this.enqueue((Item)String.valueOf(command.charAt(i)));
			}
		}
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
	
	public static void main(String[] args) {
		LLQueue<String> queue = new LLQueue<String>();
		
		queue.process("-1-2-348-569-7");

		for (String element : queue) {
			System.out.println(element);
		}
		System.out.println(queue.size);
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
}
