package dataStructures;

public class RedBlackTree <Key extends Comparable<Key>, Value extends Comparable<Value>> {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node {
		Key key;
		Value value;

		Node left;
		Node right;
		
		boolean color;

		Node(Key key, Value value, boolean color) {
			this.key = key;
			this.value = value;
			this.color = color;

			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return (key + " : " + value +" : "+color);
		}
	}

	Node root;
	
	//left rotation
	private Node leftRotation(Node node) {
		Node temp = node.right;
		node.right = temp.left;
		node.color = RED;
		temp.color = BLACK;
		temp.left = node;
		
		return temp;
	}
	//right rotation
	private Node rightRotation(Node node) {
		Node temp = node.left;
		node.left = temp.right;
		node.color = RED;
		temp.color = BLACK;
		temp.right = node;
		
		return temp;
	}
	
	//flip colors
	private Node flipColors(Node node) {
		node.left.color = BLACK;
		node.right.color = BLACK;
		node.color = RED;
		
		return node;
	}

	public void insert(Key key, Value value) {
		root = insert(root, key, value);
	}

	private Node insert(Node node, Key key, Value value) {
		if (node == null) {
			node = new Node(key, value, RED);
		} else if (key.compareTo(node.key) > 0) {
			node.right = insert(node.right, key, value);
		} else if (key.compareTo(node.key) < 0) {
			node.left = insert(node.left, key, value);
		} else {
			node.value = value;
		}

		if (isRed(node.right) && !isRed(node.left)) {
			node = leftRotation(node);
		}
		if (isRed(node.left) && isRed(node.left.left)) {
			node = rightRotation(node);
		}
		if (isRed(node.left) && isRed(node.right)) {
			node = flipColors(node);
		}
		
		return node;
	}
	
	private boolean isRed(Node node) {
		return node!=null && node.color == RED;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node node, Key key) {
		if (node == null) {
			return null;
		} else if (key.compareTo(node.key) > 0) {
			return get(node.right, key);
		} else if (key.compareTo(node.key) < 0) {
			return get(node.left, key);
		} else {
			return node.value;
		}

	}

	private void print(Node node, StringBuilder queueString) {
		if (node != null) {
			print(node.left, queueString);
			queueString.append("(" + node.key.toString() + "," + node.value.toString() + "," + node.color + ");");
			print(node.right, queueString);
		}
	}

	@Override
	public String toString() {
		StringBuilder queueString = new StringBuilder("[");
		Node node = root;

		print(node, queueString);

		if (queueString.charAt(queueString.length() - 1) == ';') {
			queueString.deleteCharAt(queueString.length() - 1);
		}
		queueString.append("]");

		return queueString.toString();
	}
	
	public static void main(String[] args) {
		RedBlackTree<String, Integer> rbTree = new RedBlackTree<String, Integer>();
		rbTree.insert("Otta", 00);
		rbTree.insert("Thumbi", 42);
		rbTree.insert("Sankar", 11);
		rbTree.insert("Mahadevan", 8);
		rbTree.insert("Chitra", 2020);
		
		System.out.println(rbTree);
	}
}

