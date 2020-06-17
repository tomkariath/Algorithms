package dataStructures;

public class TreeNode {
	private int value;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public TreeNode(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
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
	}
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public static void displayTree(TreeNode root){
		System.out.print(root.value);
		if (root.getLeftChild()!= null)
			displayTree(root.getLeftChild());
		if (root.getRightChild()!= null)
			displayTree(root.getRightChild());
	}
}
