package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private LinkedList<Item> head, tail;
	private int size = 0;

	private class ListIterator implements Iterator<Item> {
		Item currentNode;
		RandomizedQueue<Item> tempQ = new RandomizedQueue<Item>();

		@Override
		public boolean hasNext() {
			if (size() == 0) {
				head = tempQ.head;
				tail = tempQ.tail;
				size = tempQ.size();
				return false;
			}
			return true;
		}

		@Override
		public Item next() {
			currentNode = dequeue();
			tempQ.enqueue(currentNode);
			return currentNode;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove option is not supported");
		}
	}

	private static class LinkedList<Type> {
		Type element;
		LinkedList<Type> nextNode;
		LinkedList<Type> prevNode;

		public LinkedList(Type element) {
			this.element = element;
			nextNode = null;
			prevNode = null;
		}
	}

	// construct an empty randomized queue
	public RandomizedQueue() {
		head = tail = null;
		size = 0;
	}

	// is the randomized queue empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// return the number of items on the randomized queue
	public int size() {
		return size;
	}

	// add the item
	public void enqueue(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Null Values are not accepted");
		}
		if (head == null && tail == null) {
			head = new LinkedList<Item>(item);
			tail = head;
		} else {
			LinkedList<Item> newNode = new LinkedList<Item>(item);
			if (head != tail) {
				tail.nextNode = newNode;
				newNode.prevNode = tail;
				tail = newNode;
			} else {
				tail = newNode;
				head.nextNode = tail;
				tail.prevNode = head;
			}
		}
		size++;
	}

	// remove and return a random item
	public Item dequeue() {
		if (size == 0) {
			throw new NoSuchElementException("The Queue is Empty");
		} else {
			int index = generateRandomIndex(size);
			// StdOut.println("Idenx"+index+" size "+size);
			LinkedList<Item> dqNode = getNodeAtIndex(index);

			if (size == 1) {
				head = tail = null;
				size--;
			} else if (dqNode == head) {
				head = head.nextNode;
				head.prevNode = null;
				size--;
			} else if (dqNode == tail) {
				tail = tail.prevNode;
				tail.nextNode = null;
				size--;
			} else {
				dqNode.prevNode.nextNode = dqNode.nextNode;
				dqNode.nextNode.prevNode = dqNode.prevNode;
				size--;
			}
			return dqNode.element;
		}
	}

	// return a random item (but do not remove it)
	public Item sample() {
		if (size == 0) {
			throw new NoSuchElementException("Queue is empty");
		}
		return getNodeAtIndex(generateRandomIndex(size)).element;
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private int generateRandomIndex(int size) {
		if (size > 0) {
			return StdRandom.uniform(size);
		} else {
			return 0;
		}
	}

	private LinkedList<Item> getNodeAtIndex(int index) {
		LinkedList<Item> node = this.head;
		for (int i = 0; i < index; i++) {
			node = node.nextNode;
		}
		return node;
	}

	// unit testing (required)
	public static void main(String[] args) {
		RandomizedQueue<Integer> randomQueue = new RandomizedQueue<Integer>();
		StdOut.println(randomQueue.isEmpty());
		// randomQueue.sample();
		// randomQueue.dequeue();

		// randomQueue.enqueue(null);
		randomQueue.enqueue(0);
		randomQueue.enqueue(1);
		randomQueue.enqueue(2);
		randomQueue.enqueue(3);
		randomQueue.enqueue(4);
		randomQueue.enqueue(5);
		randomQueue.enqueue(6);
		randomQueue.enqueue(7);

		StdOut.println("Removed " + randomQueue.dequeue());
		StdOut.println("Removed " + randomQueue.dequeue());
		StdOut.println("Removed " + randomQueue.dequeue());
		// StdOut.println("Removed "+randomQueue.dequeue());

		StdOut.println("SAmple " + randomQueue.sample());
		StdOut.println("SAmple " + randomQueue.sample());
		StdOut.println("SAmple " + randomQueue.sample());

		LinkedList<Integer> node = randomQueue.head;
		while (node != null) {
			System.out.print(node.element);
			node = node.nextNode;
		}

		StdOut.println(randomQueue.size());

		/*
		 * for (Integer integer : randomQueue) { StdOut.println(integer); }
		 */

		/*
		 * Iterator<Integer> iterator = randomQueue.iterator(); while
		 * (iterator.hasNext()) { //StdOut.println("SAmple "+randomQueue.sample());
		 * iterator.next(); }
		 */

		for (Integer integer : randomQueue) {
			StdOut.println(integer);
		}
	}
}