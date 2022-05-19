package problems;
import dataStructures.Node;

// 1->2->3->4->5

public class ReverseLL {

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2, node1);
        Node<Integer> node3 = new Node<Integer>(3, node2);
        Node<Integer> node4 = new Node<Integer>(4, node3);
        Node<Integer> node5 = new Node<Integer>(5, node4);
        Node<Integer> node6 = new Node<Integer>(6, node5);

        reverseLinkedList(node6);
    }

    private static void reverseLinkedList (Node<Integer> head){
        Node<Integer> newHead = reverse(null, head, head.getNextNode());

        while (newHead!=null){
            System.out.println(newHead.getElement());
            newHead = newHead.getNextNode();
        }
    }

    private static Node<Integer> reverse(Node<Integer> before, Node<Integer> current, Node<Integer> after){
        Node<Integer> future = after.getNextNode();
        after.setNextNode(current);
        current.setNextNode(before);

        if (future == null){
            return after;
        }

        return reverse(current, after, future);
    }
}
