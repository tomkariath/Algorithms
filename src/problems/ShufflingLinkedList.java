package problems;

import dataStructures.Node;
import edu.princeton.cs.algs4.StdRandom;

public class ShufflingLinkedList {

	public Node<Integer> randomize (Node<Integer> node) {
		Node<Integer> prevNode=null;
		Node<Integer> firstNode=node;

		while (node!=null) {
			if(StdRandom.uniform(2)>0) {
				if (prevNode == null) {
					prevNode = node;
				}
				else {
					prevNode.setNextNode(node.getNextNode());
					node.setNextNode(firstNode);
					firstNode = node;
				}
				node = prevNode.getNextNode();
			}
			else {
				if (prevNode == null) {
					prevNode = node;
				}
				else {
					prevNode = prevNode.getNextNode();
				}
				node = node.getNextNode();
			}
		}
		return firstNode;
	}

	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2, node1);
		Node<Integer> node3 = new Node<Integer>(3, node2);
		Node<Integer> node4 = new Node<Integer>(4, node3);
		Node<Integer> node5 = new Node<Integer>(5, node4);

		ShufflingLinkedList sll = new ShufflingLinkedList();
		Node<Integer> node = sll.randomize(node5);

		while (node != null) {
			System.out.println(node.getElement());
			node = node.getNextNode();
		}
	}
}
