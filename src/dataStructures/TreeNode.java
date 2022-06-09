package dataStructures;

public class TreeNode {
	private int value;
	private TreeNode leftChild;
	private TreeNode rightChild;
	private int distanceFromRoot;

	public TreeNode(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.distanceFromRoot = 0;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
		if (leftChild != null) {
			leftChild.distanceFromRoot = this.distanceFromRoot + 1;
		}
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
		if (rightChild != null)
			rightChild.distanceFromRoot = this.distanceFromRoot + 1;
	}

	public int getDistanceFromRoot() {
		return distanceFromRoot;
	}

	public static void displayTree(TreeNode root) {
		if (root.getLeftChild() != null)
			displayTree(root.getLeftChild());
		System.out.print("(" + root.value + " " + root.distanceFromRoot + ")");
		if (root.getRightChild() != null)
			displayTree(root.getRightChild());
	}
}
