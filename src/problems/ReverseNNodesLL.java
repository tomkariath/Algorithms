package problems;

import dataStructures.Node;

public class ReverseNNodesLL {

	public static void main(String[] args) {
		
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2, node1);
		Node<Integer> node3 = new Node<Integer>(3, node2);
		Node<Integer> node4 = new Node<Integer>(4, node3);
		Node<Integer> node5 = new Node<Integer>(5, node4);
		Node<Integer> node6 = new Node<Integer>(6, node5);
		
		Node<Integer> resultStartNode = sectionReverse(node6, 3);
		
		while (resultStartNode != null) {
			System.out.println(resultStartNode.getElement());
			resultStartNode = resultStartNode.getNextNode();
		}
	}

	private static Node<Integer> sectionReverse(Node<Integer> head, int sectionSize) {
		
		Node<Integer> previous = null;
		Node<Integer> current = head;
		Node<Integer> next = null;
		int count = 0;
		
		while (count<sectionSize && current!=null) {
			//System.out.println(current.getElement());
			next = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = next;
			count++;
		}
		
		if (current!=null) {
			head.setNextNode(sectionReverse(current, sectionSize));
		}
		
		return previous;
	}
	
}
