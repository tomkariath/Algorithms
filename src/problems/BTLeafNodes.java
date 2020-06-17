package problems;

import java.util.LinkedList;

import dataStructures.TreeNode;

public class BTLeafNodes {
	static LinkedList<Integer> leafList = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n1.setLeftChild(n2);
		n1.setRightChild(n3);
		n2.setLeftChild(n4);
		n2.setRightChild(n5);
		
		TreeNode.displayTree(n1);
		
		System.out.println();
		findLeafNodes(n1);
		
		System.out.println(leafList.toString());
	}

	private static void findLeafNodes(TreeNode root) {
		if (root.getLeftChild()== null && root.getRightChild() == null) {
			leafList.add(root.getValue());
		}
		else {
			if(root.getLeftChild() != null) {
			findLeafNodes(root.getLeftChild());
		}
			if (root.getRightChild() != null){
			findLeafNodes(root.getRightChild());
		}
		}
	}
	
}
