package dataStructures;

public class Node<Item> {
	
	Item element;
	Node<Item> nextNode;
	
	public Node(Item element) {
		this.element = element;
		nextNode = null;
	}
	
	public Node() {
		this.element = null;
		nextNode = null;
	}
	
	public Node(Item element, Node<Item> node) {
		this.element = element;
		nextNode = node;
	}
	
	public Node<Item> getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node<Item> node) {
		nextNode = node;
	}

	public Item getElement() {
		return element;
	}

	public void setElement(Item element) {
		this.element = element;
	}
}
