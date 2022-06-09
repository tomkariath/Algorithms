package problems;

import dataStructures.TreeNode;

public class LCABinaryTree {

	TreeNode root;
	boolean found1, found2;

	public static void main(String[] args) {
		LCABinaryTree tree = new LCABinaryTree();
		tree.root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		tree.root.setLeftChild(n2);
		tree.root.setRightChild(n3);
		n2.setLeftChild(n4);
		n2.setRightChild(n5);
		n3.setLeftChild(n6);
		n3.setRightChild(n7);

		//TreeNode n8 = new TreeNode(8);
		//TreeNode n9 = new TreeNode(8);

		TreeNode.displayTree(tree.root);

		System.out.println();
		TreeNode lca = tree.findLCA(n3, n5);
		if (lca != null) {
			System.out.println(lca.getValue());
		} else {
			System.out.println("Atleast one of the nodes are missing");
		}
		
		int dist = tree.distanceBetween(n2, n6);
		if (dist!=-1) {
			System.out.println(dist);
		}
		else {
			System.out.println("Atleast one of the nodes are missing");
		}
	}

	public TreeNode findLCA(TreeNode node1, TreeNode node2) {
		return findLCA(root, node1, node2);
	}

	private TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {

		TreeNode lca = findLCAUtil(root, node1, node2);

		if (found1 && found2) {
			return lca;
		} else {
			return null;
		}
	}

	private TreeNode findLCAUtil(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null) {
			return null;
		}
		else {
			TreeNode tempNode = null;

			if (root.getValue() == node1.getValue()) {
				found1 = true;
				if (node1 == node2) {
					found2 = true;
					return node1;
				}
				tempNode = root;
			} else if (root.getValue() == node2.getValue()) {
				found2 = true;
				tempNode = root;
			}
			TreeNode left_LCA = findLCAUtil(root.getLeftChild(), node1, node2);
			TreeNode right_LCA = findLCAUtil(root.getRightChild(), node1, node2);
			
			if (tempNode!=null) {
				return tempNode;
			}

			if (left_LCA != null && right_LCA != null) {
				return root;
			} else if (left_LCA != null) {
				return left_LCA;
			} else if (right_LCA != null) {
				return right_LCA;
			} else {
				return null;
			}
		}
	}
	
	public int distanceBetween(TreeNode node1, TreeNode node2) {
		if (node1 == node2) {
			return 0;
		}
		
		TreeNode lca = findLCA(node1, node2);
		if (lca!=null)
			return node1.getDistanceFromRoot() + node2.getDistanceFromRoot() - (2 * lca.getDistanceFromRoot());
		else 
			return -1;
	}
}
