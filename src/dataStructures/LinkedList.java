package dataStructures;

public class LinkedList {
	
	String element;
	LinkedList nextNode;
	
	public LinkedList(String element) {
		this.element = element;
		nextNode = null;
	}
	
	public LinkedList(String element, LinkedList node) {
		this.element = element;
		nextNode = node;
	}
}
