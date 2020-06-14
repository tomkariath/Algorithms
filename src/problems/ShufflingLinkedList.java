package problems;

import dataStructures.LinkedList;
import edu.princeton.cs.algs4.StdRandom;

public class ShufflingLinkedList {

	public LinkedList<Integer> randomize (LinkedList<Integer> node) {
		LinkedList<Integer> prevNode=null;
		LinkedList<Integer> firstNode=node;

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
		LinkedList<Integer> node1 = new LinkedList<Integer>(1);
		LinkedList<Integer> node2 = new LinkedList<Integer>(2, node1);
		LinkedList<Integer> node3 = new LinkedList<Integer>(3, node2);
		LinkedList<Integer> node4 = new LinkedList<Integer>(4, node3);
		LinkedList<Integer> node5 = new LinkedList<Integer>(5, node4);

		ShufflingLinkedList sll = new ShufflingLinkedList();
		LinkedList<Integer> node = sll.randomize(node5);

		while (node != null) {
			System.out.println(node.getElement());
			node = node.getNextNode();
		}
	}
}
