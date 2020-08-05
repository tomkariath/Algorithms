package dataStructures;

public class TreeNode {
	private int value;
	private TreeNode leftChild;
	private TreeNode rightChild;
	private int distaneFromRoot;

	public TreeNode(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.distaneFromRoot = 0;
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
		if (leftChild != null)
			leftChild.distaneFromRoot = this.distaneFromRoot + 1;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
		if (rightChild != null)
			rightChild.distaneFromRoot = this.distaneFromRoot + 1;
	}

	public int getDistaneFromRoot() {
		return distaneFromRoot;
	}

	public void setDistaneFromRoot(int distaneFromRoot) {
		this.distaneFromRoot = distaneFromRoot;
	}

	public static void displayTree(TreeNode root) {
		if (root.getLeftChild() != null)
			displayTree(root.getLeftChild());
		System.out.print("(" + root.value + " " + root.distaneFromRoot + ")");
		if (root.getRightChild() != null)
			displayTree(root.getRightChild());
	}
}
