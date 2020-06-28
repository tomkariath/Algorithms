package problems;

import dataStructures.TreeNode;

public class MirrorTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.setLeftChild(n2);
		n1.setRightChild(n3);
		n2.setLeftChild(n4);
		n2.setRightChild(n5);
		n3.setLeftChild(n6);
		n3.setRightChild(n7);
		
		TreeNode.displayTree(n1);
		
		System.out.println();
		
		getMirrorTree(n1);
		
		TreeNode.displayTree(n1);
	}

	private static void getMirrorTree(TreeNode node) {
		if (node.getRightChild()!=null) {
			getMirrorTree(node.getRightChild());
		}
		if (node.getLeftChild()!=null) {
			getMirrorTree(node.getLeftChild());
		}
		swapChildren(node);
	}

	private static void swapChildren(TreeNode node) {
		TreeNode tempNode = node.getLeftChild();
		node.setLeftChild(node.getRightChild());
		node.setRightChild(tempNode);
	}
}
