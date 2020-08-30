package dataStructures;

public class IntervalSearchTree<Type extends Comparable<Type>> {

	private class Node {
		Type leftInterval;
		Type rightInterval;

		Node left;
		Node right;

		Type maxValue;

		Node(Type leftInterval, Type rightInterval) {
			this.leftInterval = leftInterval;
			this.rightInterval = rightInterval;

			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return (leftInterval + " : " + rightInterval + " : " + maxValue);
		}
	}

	Node root;

	public void insert(Type leftInterval, Type rightInterval) {
		root = insert(root, leftInterval, rightInterval);
	}

	private Node insert(Node node, Type leftInterval, Type rightInterval) {
		if (node == null) {
			node = new Node(leftInterval, rightInterval);
		} else if (leftInterval.compareTo(node.leftInterval) > 0) {
			node.right = insert(node.right, leftInterval, rightInterval);
		} else if (leftInterval.compareTo(node.leftInterval) < 0) {
			node.left = insert(node.left, leftInterval, rightInterval);
		} else {
			node.rightInterval = rightInterval;
		}

		Type maxCandidate = getMax(getMaxInterval(node.left), getMaxInterval(node.right));
		if (maxCandidate == null) {
			node.maxValue = node.rightInterval;
		} else {
			node.maxValue = getMax(maxCandidate, node.maxValue);
		}
		return node;
	}

	private Type getMax(Type leftMax, Type rightMax) {
		if (leftMax == null && rightMax == null) {
			return null;
		} else if (rightMax == null || (leftMax != null && leftMax.compareTo(rightMax) > 0)) {
			return leftMax;
		} else {
			return rightMax;
		}
	}

	private Type getMaxInterval(Node node) {
		if (node == null) {
			return null;
		}
		return node.maxValue;
	}

	public Node get(Type leftInterval) {
		return get(root, leftInterval);
	}

	private Node get(Node node, Type leftInterval) {
		if (node == null) {
			return null;
		} else if (leftInterval.compareTo(node.leftInterval) > 0) {
			return get(node.right, leftInterval);
		} else if (leftInterval.compareTo(node.leftInterval) < 0) {
			return get(node.left, leftInterval);
		} else {
			return node;
		}

	}

	private void print(Node node, StringBuilder queueString) {
		if (node != null) {
			print(node.left, queueString);
			queueString.append("(" + node.leftInterval.toString() + "," + node.rightInterval.toString() + ");");
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

	// TODO public getIntersection
	public void getIntersection(Type leftInterval, Type rightInterval) {
		getIntersection(root, leftInterval, rightInterval);
	}

	private void getIntersection(Node node, Type leftInterval, Type rightInterval) {
		if ((leftInterval.compareTo(node.leftInterval) >= 0 && leftInterval.compareTo(node.rightInterval) <= 0)
				|| (rightInterval.compareTo(node.leftInterval) >= 0
						&& rightInterval.compareTo(node.rightInterval) <= 0)) {
			System.out.println("(" + leftInterval + "," + rightInterval + ") intersects with + " + "("
					+ node.leftInterval + "," + node.rightInterval + ")");
		} else if (node.left == null) {
			getIntersection(node.right, leftInterval, rightInterval);
		} else if (node.left.maxValue.compareTo(leftInterval) < 0) {
			getIntersection(node.right, leftInterval, rightInterval);
		} else {
			getIntersection(node.left, leftInterval, rightInterval);
		}
	}

	public static void main(String[] args) {
		IntervalSearchTree<Integer> ist = new IntervalSearchTree<Integer>();

		ist.insert(1, 5);
		ist.insert(11, 14);
		ist.insert(12, 13);
		ist.insert(23, 37);
		ist.insert(29, 38);
		ist.insert(15, 20);
		ist.insert(2, 8);
		ist.insert(3, 6);

		System.out.println(ist);

		System.out.println("Get " + ist.get(1));

		ist.getIntersection(10, 16);
	}
}
