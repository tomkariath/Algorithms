package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
	private LinkedList<Item> head;
	private LinkedList<Item> tail;
	private int size;

	private class ListIterator implements Iterator<Item> {
		LinkedList<Item> currentNode = head;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No more items in the queue");
			}
			Item item = currentNode.element;
			currentNode = currentNode.nextNode;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove option is not supported");
		}
	}

	private class LinkedList<Type> {
		Type element;
		LinkedList<Type> nextNode;
		LinkedList<Type> prevNode;

		public LinkedList(Type element) {
			this.element = element;
			nextNode = null;
			prevNode = null;
		}

		public LinkedList(Type element, LinkedList<Type> node) {
			this.element = element;
			nextNode = node;
			prevNode = null;
		}
	}

	// construct an empty deque
	public Deque() {
		head = tail = null;
		size = 0;
	}

	// is the deque empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// return the number of items on the deque
	public int size() {
		return size;
	}

	// add the item to the front
	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("need non-null input");
		}
		if (head == null) {
			head = new LinkedList<Item>(item);
			tail = head;
			size++;
		} else {
			LinkedList<Item> temp = new LinkedList<Item>(item, head);
			head.prevNode = temp;
			head = temp;
			size++;
		}
	}

	// add the item to the back
	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("need non-null input");
		}
		if (tail == null) {
			head = tail = new LinkedList<Item>(item);
			size++;
		} else {
			LinkedList<Item> newNode = new LinkedList<Item>(item);
			newNode.prevNode = tail;
			if (head != tail) {
				tail.nextNode = newNode;
				tail = newNode;
				size++;
			} else {
				tail = newNode;
				head.nextNode = tail;
				size++;
			}
		}
	}

	// remove and return the item from the front
	public Item removeFirst() {
		Item tempData;
		if (head == null) {
			throw new NoSuchElementException("Queue is empty");
		} else if (head == tail) {
			tempData = head.element;
			head = tail = null;
			size--;
		} else {
			tempData = head.element;
			head = head.nextNode;
			head.prevNode = null;
			size--;
		}
		return tempData;
	}

	// remove and return the item from the back
	public Item removeLast() {
		Item tempData;
		if (tail == null) {
			throw new NoSuchElementException("Queue is empty");
		} else if (head == tail) {
			tempData = tail.element;
			head = tail = null;
			size--;
		} else {
			tempData = tail.element;
			tail = tail.prevNode;
			tail.nextNode = null;
			size--;
		}
		return tempData;
	}

	@Override
	// return an iterator over items in order from front to back
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	// unit testing (required)
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		StdOut.println(deque.isEmpty());
		deque.addFirst(1);
		deque.addFirst(2);

		// deque.addFirst(null);

		deque.addFirst(3);
		deque.addLast(4);
		deque.addFirst(5);
		deque.addLast(6);

		deque.removeFirst();
		deque.removeLast();
		deque.removeFirst();
		deque.removeFirst();

		StdOut.println(deque.size());

		Iterator<Integer> iterator = deque.iterator();
		while (iterator.hasNext()) {
			StdOut.println(iterator.next());
		}
	}
}