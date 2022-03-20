package dataStructures;

public class LinkedList {
    private Node<String> startNode = new Node<>();

    public void reverse() {
        Node<String> nextNode = startNode.getNextNode();
        startNode.setNextNode(null);
        reverse(nextNode, startNode);
    }

    private void reverse(Node<String> currentNode, Node<String> previousNode) {
        if (currentNode.getNextNode() == null) {
            startNode = previousNode;
            return;
        }

        Node<String> nextNode = currentNode.getNextNode();
        currentNode.setNextNode(previousNode);
        reverse(nextNode, currentNode);
    }

    public void add(String text) {
        add(startNode, text);
    }

    private void add (Node<String> node, String text){
        if (node.getElement() == null){
            node.setElement(text);
            node.setNextNode(new Node<>());
            return;
        }
        add(node.getNextNode(), text);
    }

    public Node<String> getStartNode() {
        return startNode;
    }

    private static void printLinkedList(Node<String> startNode){
        Node<String> nextNode = startNode;
        while (nextNode!=null && nextNode.getElement() != null) {
            System.out.println(nextNode.element);
            nextNode = nextNode.getNextNode();
        }
    }

    public static void main(String[] args) {
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.add("a");
        testLinkedList.add("b");
        testLinkedList.add("c");

        printLinkedList(testLinkedList.getStartNode());

        testLinkedList.reverse();

        printLinkedList(testLinkedList.getStartNode());
    }
}
