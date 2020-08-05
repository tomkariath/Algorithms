package problems;

import dataStructures.TreeNode;

public class CheckIfBST {
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(5);
		
		n2.setLeftChild(n1);
		n2.setRightChild(n3);
		
		n5.setRightChild(n6);
		
		n4.setLeftChild(n2);
		n4.setRightChild(n5);
		
		displayTree(n4);
		
		System.out.println(checkBST(n4));
	}
	
	public static void displayTree(TreeNode root) {
		if (root.getLeftChild() != null)
			displayTree(root.getLeftChild());
		System.out.print(root.getValue());
		if (root.getRightChild() != null)
			displayTree(root.getRightChild());
	}
	
	public static boolean checkBST(TreeNode node) {
		if (node.getLeftChild()!=null) {
			if (node.getLeftChild().getValue()>node.getValue()) {
				return false;
			}
			else if (!checkBST(node.getLeftChild())) {
				return false;
			}
		}
		if (node.getRightChild()!=null) {
			if (node.getRightChild().getValue()<node.getValue()) {
				return false;
			}
			else if (!checkBST(node.getRightChild())) {
				return false;
			}
		}
		return true;
	}

}
