package dataStructures;

public class LinkedList<Item> {
	
	Item element;
	LinkedList<Item> nextNode;
	
	public LinkedList(Item element) {
		this.element = element;
		nextNode = null;
	}
	
	public LinkedList(Item element, LinkedList<Item> node) {
		this.element = element;
		nextNode = node;
	}
}
