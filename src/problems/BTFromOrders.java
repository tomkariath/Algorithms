package problems;

import java.util.Arrays;

import dataStructures.TreeNode;

public class BTFromOrders {

	public static void main(String[] args) {
		String preorder = "abdhiecfgjk";
		String postorder = "hidebfjkgca";

		TreeNode root = getTree(preorder, postorder);

		TreeNode.displayTree(root);
	}

	private static TreeNode getTree(String preorder, String postorder) {
		int preIndex = 0, postIndex = postorder.length() - 1;
		TreeNode root = new TreeNode(preorder.charAt(preIndex));
		preIndex++;
		postIndex--;

		root.setLeftChild(new TreeNode(preorder.charAt(preIndex)));
		root.setRightChild(new TreeNode(postorder.charAt(postIndex)));
		preorder = preorder.substring(preIndex + 1);

		getTreeUtil(root, preorder, postorder, preIndex, postIndex);

		return root;
	}

	private static void getTreeUtil(TreeNode root, String preorder, String postorder, int preIndex, int postIndex) {
		// String[] subTrees =
		// preorder.split(Character.toString(postorder.charAt(postIndex)));
		String[] subTrees = new String[2];
		String split1 = preorder.substring(0, preorder.indexOf(postorder.charAt(postIndex)));
		String split2 = preorder.substring(preorder.indexOf(postorder.charAt(postIndex)) + 1);

		subTrees[0] = split1.length() > 0 ? split1 : Character.toString(postorder.charAt(postIndex));
		subTrees[1] = split2.length() > 0 ? split2 : Character.toString(postorder.charAt(postIndex));

		postIndex--;
		preIndex++;

		System.out.println(Arrays.toString(subTrees));

		if (subTrees[0].length() > 3) {
			getTreeUtil(root.getLeftChild(), subTrees[0], postorder, preIndex, postIndex - (subTrees[1].length() + 1));
		} else if (subTrees[0].length() == 3) {
			TreeNode head = new TreeNode(subTrees[0].charAt(0));
			TreeNode left = new TreeNode(subTrees[0].charAt(1));
			TreeNode right = new TreeNode(subTrees[0].charAt(2));
			head.setLeftChild(left);
			head.setRightChild(right);
			root.setLeftChild(head);
		} else {
			TreeNode head = new TreeNode(subTrees[0].charAt(0));
			root.setLeftChild(head);
		}

		if (subTrees[1].length() > 3) {
			getTreeUtil(root.getRightChild(), subTrees[1], postorder, preIndex, postIndex - (subTrees[1].length() - 1));
		} else if (subTrees[1].length() == 3) {
			TreeNode head = new TreeNode(subTrees[1].charAt(0));
			TreeNode left = new TreeNode(subTrees[1].charAt(1));
			TreeNode right = new TreeNode(subTrees[1].charAt(2));
			head.setLeftChild(left);
			head.setRightChild(right);
			root.setRightChild(head);
		} else {
			TreeNode head = new TreeNode(subTrees[1].charAt(0));
			root.setRightChild(head);
		}
	}
}
