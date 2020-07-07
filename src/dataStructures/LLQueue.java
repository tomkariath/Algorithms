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
	}
	
	public void dequeue() {
		if(head!=null) {
			if(head==tail) {
				tail=null;
				head=null;
			}
			else {
				head = head.nextNode;
			}
		}
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
	
	public static void main(String[] args) {
		LLQueue<String> queue = new LLQueue<String>();
		
		queue.process("-1-2-348-569-7");

		for (String element : queue) {
			System.out.println(element);
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
}
