package dataStructures;

public class LinkedList<Item> {
	
	Item element;
	LinkedList<Item> nextNode;
	
	public LinkedList(Item element) {
		this.element = element;
		nextNode = null;
	}
	
	public LinkedList() {
		this.element = null;
		nextNode = null;
	}
	
	public LinkedList(Item element, LinkedList<Item> node) {
		this.element = element;
		nextNode = node;
	}
	
	public LinkedList<Item> getNextNode() {
		return nextNode;
	}
	public void setNextNode(LinkedList<Item> node) {
		nextNode = node;
	}

	public Item getElement() {
		return element;
	}

	public void setElement(Item element) {
		this.element = element;
	}
}
