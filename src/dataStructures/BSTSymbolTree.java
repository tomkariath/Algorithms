package dataStructures;

public class BSTSymbolTree<Key extends Comparable<Key>, Value extends Comparable<Value>> {
	private class Node {
		Key key;
		Value value;
		
		Node left;
		Node right;
		
		Node(Key key, Value value){
			this.key = key;
			this.value = value;
			
			left = null;
			right = null;
		}
	}

	Node root;
	
	public void insert (Key key, Value value) {
		root = insert(root, key, value);
	}
	
	private Node insert(Node root, Key key, Value value) {
		if (root == null) {
			root = new Node(key, value);
		}
		else if (key.compareTo(root.key) > 0) {
			root.right =  insert(root.right, key, value);
		}
		else if (key.compareTo(root.key) < 0) {
			root.left = insert(root.left, key, value);
		}
		else {
			root.value = value;
		}
		return root;
	}
	
	public Value get(Key key) {
		return get(root, key);
	}
	
	private Value get (Node node, Key key) {
		if (node == null) {
			return null;
		}
		else if (key.compareTo(node.key) > 0) {
			return get(node.right, key);
		}
		else if (key.compareTo(node.key) < 0) {
			return get(node.left, key);
		}
		else {
			 return node.value;
		}
	
	}
	
	private void print(Node node, StringBuilder queueString) {
		if (node != null) {
			queueString.append("("+node.key.toString() + ","+node.value.toString()+");");
			print(node.left, queueString);
			print(node.right, queueString);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder queueString = new StringBuilder("[");
		Node node = root;

		print(node, queueString);

		if (queueString.charAt(queueString.length() - 1)==';') {
			queueString.deleteCharAt(queueString.length() - 1);
		}
		queueString.append("]");

		return queueString.toString();
	}
	
	public static void main(String[] args) {
		BSTSymbolTree<String, Integer> bst = new BSTSymbolTree<String, Integer>();
		
		bst.insert("Enna", 1);
		bst.insert("Nadannanthalum", 2);
		bst.insert("From", 3);
		bst.insert("Meesaya", 4);
		bst.insert("Murukku", 5);
		
		System.out.println(bst);
		
		System.out.println(bst.get("From"));
		System.out.println(bst.get("New"));
	}
}
