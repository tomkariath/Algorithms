package dataStructures;

import java.util.Iterator;

public class LLStack<Item> implements Iterable<Item>{
	
	
	private class ListIterator implements Iterator<Item>{
		
		LinkedList<Item> currentNode = root;

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
	
	private LinkedList<Item> root;
	private int size=0;
	
	public void push(Item element) {
		
		if(root == null) {
			root = new LinkedList<Item>(element);
		}
		else {
			LinkedList<Item> newNode = new LinkedList<Item>(element, root);
			root = newNode;
		}
		size++;
	}
	
	public Item pop () {
		if(root!=null) {
			Item poppedItem = root.element;
			root = root.nextNode;
			size--;
			return poppedItem;
		}
		return null;
	}
	
	private static void process (LLStack<String> stack, String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i)=='-') {
				stack.pop();
			}
			else {
				stack.push(String.valueOf(command.charAt(i)));
			}
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public static void main(String[] args) {
		LLStack<String> stack = new LLStack<String>();
		
		process(stack, "-1-2-34-567");
		
		for (String element : stack) {
			System.out.println(element);
		}
		System.out.println("Size "+stack.getSize());
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
}
