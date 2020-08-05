package dataStructures;

public class BSTSymbolTree<Key extends Comparable<Key>, Value extends Comparable<Value>> {
	private class Node {
		Key key;
		Value value;

		Node left;
		Node right;

		int size;

		Node(Key key, Value value) {
			this.key = key;
			this.value = value;

			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return (key + " : " + value + " : " + size);
		}
	}

	Node root;

	public void insert(Key key, Value value) {
		root = insert(root, key, value);
	}

	private Node insert(Node node, Key key, Value value) {
		if (node == null) {
			node = new Node(key, value);
		} else if (key.compareTo(node.key) > 0) {
			node.right = insert(node.right, key, value);
		} else if (key.compareTo(node.key) < 0) {
			node.left = insert(node.left, key, value);
		} else {
			node.value = value;
		}

		node.size = 1 + getSize(node.left) + getSize(node.right);
		return node;
	}

	private int getSize(Node node) {
		if (node == null) {
			return 0;
		}
		return node.size;
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
			queueString.append("(" + node.key.toString() + "," + node.value.toString() + ");");
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

	public Value floor(Key key) {
		return floor(root, key);
	}

	private Value floor(Node node, Key key) {
		if (node == null) {
			return null;
		} else if (key.compareTo(node.key) > 0) {
			Value temp = floor(node.right, key);
			if (temp != null) {
				return temp;
			} else {
				return node.value;
			}
		} else if (key.compareTo(node.key) < 0) {
			return floor(node.left, key);
		} else {
			return node.value;
		}
	}

	public Value ceiling(Key key) {
		return ceiling(root, key);
	}

	private Value ceiling(Node node, Key key) {
		if (node == null) {
			return null;
		} else if (key.compareTo(node.key) < 0) {
			Value temp = ceiling(node.left, key);
			if (temp != null) {
				return temp;
			} else {
				return node.value;
			}
		} else if (key.compareTo(node.key) > 0) {
			return ceiling(node.right, key);
		} else {
			return node.value;
		}
	}

	public Node minNode() {
		if (root == null) {
			return null;
		}
		return getMin(root);
	}

	private Node getMin(Node node) {
		if (node.left != null) {
			return getMin(node.left);
		} else {
			return node;
		}
	}

	public Node maxNode() {
		if (root == null) {
			return null;
		}
		return getMax(root);
	}

	private Node getMax(Node node) {
		if (node.right != null) {
			return getMax(node.right);
		} else {
			return node;
		}
	}

	public int rank(Key key) {
		return 1 + rank(root, key);
	}

	private int rank(Node node, Key key) {
		if (node == null) {
			return 0;
		}
		int cmpValue = key.compareTo(node.key);
		if (cmpValue == 0) {
			return getSize(node.left);
		} else if (cmpValue < 0) {
			return rank(node.left, key);
		} else {
			return 1 + getSize(node.left) + rank(node.right, key);
		}

	}

	public void deleteMin() {
		if (root==null) {
			return;
		}
		root = deleteMin(root);
	}

	private Node deleteMin(Node node) {
		
		if (node.left != null) {
			node.left = deleteMin(node.left);
			return node;
		} else {
			return node.right;
		}		
	}
	
	public void deleteMax() {
		if (root==null) {
			return;
		}
		root = deleteMax(root);
	}

	private Node deleteMax(Node node) {
		
		if (node.right != null) {
			node.right = deleteMax(node.right);
			return node;
		} else {
			return node.left;
		}		
	}
	
	public void deleteKey (Key key) {
		if (root == null) {
			return;
		}
		root = deleteKey(root, key);
	}
	
	private Node deleteKey(Node node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmpResult = key.compareTo(node.key);
		
		if (cmpResult > 0) {
			node.right = deleteKey(node.right, key);
		}
		else if (cmpResult < 0) {
			node.left = deleteKey(node.left, key);
		}
		else {
			if (node.right == null && node.left == null) {
				return null;
			}
			else if (node.right == null) {
				return node.left;
			}
			else if (node.left == null) {
				return node.right;
			}
			else {
				Node temp = getMin(node.right);
				temp.left = node.left;
				temp.right = deleteMin(node.right);
				return temp;
			}
		}
		node.size = 1 + getSize(node.left) + getSize(node.right);
		return node;
	}

	public static void main(String[] args) {
		BSTSymbolTree<String, Integer> bst = new BSTSymbolTree<String, Integer>();

		bst.insert("Enna", 1);
		bst.insert("Nadannanthalum", 2);
		bst.insert("From", 3);
		bst.insert("Meesaya", 4);
		bst.insert("Murukku", 5);
		bst.insert("Arabu", 6);
		bst.insert("Aromale", 1518);
		bst.insert("Kandisa", 2116);
		bst.insert("Madari", 2130);
		bst.insert("Kannane", 1324);
		bst.insert("Kanne", 208);

		System.out.println(bst);

		System.out.println("Get " + bst.get("From"));
		// System.out.println(bst.get("New"));

		System.out.println("Floor " + bst.floor("Ghost"));
		// System.out.println(bst.floor("Aviating"));

		System.out.println("Ceiling " + bst.ceiling("Harris"));

		System.out.println("Min " + bst.minNode());
		System.out.println("Max " + bst.maxNode());

		System.out.println("Rank " + bst.rank("Aromale"));
		
		bst.deleteMin();
		System.out.println(bst);
		
		bst.deleteMax();
		System.out.println(bst);
		
		bst.deleteKey("Kannane");
		System.out.println(bst);
	}
}
