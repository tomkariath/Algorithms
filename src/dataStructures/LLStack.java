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
	
	LinkedList<Item> root;
	
	public void push(Item element) {
		
		if(root == null) {
			root = new LinkedList<Item>(element);
		}
		else {
			LinkedList<Item> newNode = new LinkedList<Item>(element, root);
			root = newNode;
		}
	}
	
	public Item pop () {
		if(root!=null) {
			Item poppedItem = root.element;
			root = root.nextNode;
			return poppedItem;
		}
		return null;
	}
	
	public static void process (LLStack<String> stack, String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i)=='-') {
				stack.pop();
			}
			else {
				stack.push(String.valueOf(command.charAt(i)));
			}
		}
	}
	
	public static void main(String[] args) {
		LLStack<String> stack = new LLStack<String>();
		
		process(stack, "-1-2-34-567");
		
		for (String element : stack) {
			System.out.println(element);
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
}
