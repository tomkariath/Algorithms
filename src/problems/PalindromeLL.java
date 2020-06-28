package problems;

import dataStructures.Node;

public class PalindromeLL {

	public static void main(String[] args) {

		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2, node1);
		Node<Integer> node3 = new Node<Integer>(3, node2);
		Node<Integer> node4 = new Node<Integer>(3, node3);
		Node<Integer> node5 = new Node<Integer>(2, node4);
		Node<Integer> node6 = new Node<Integer>(2, node5);

		System.out.println(checkPalindrome(node6));
	}

	private static boolean checkPalindrome(Node<Integer> node) {
		
		String original = convertToString(node);
		
		Node<Integer> reverseNode = reverse(node);
		String reverse = convertToString(reverseNode);
		
		return original.equals(reverse);
	}

	private static String convertToString(Node<Integer> node) {
		String temp = "";
		while (node != null) {
			temp = temp.concat(Integer.toString(node.getElement()));
			node = node.getNextNode();
		}
		return temp;
	}

	private static Node<Integer> reverse(Node<Integer> node) {
		Node<Integer> prev = null;
		Node<Integer> next = null;
		
		while (node !=null) {
			next = node.getNextNode();
			node.setNextNode(prev);
			prev = node;
			node = next;
		}
		return prev;
	}
}
