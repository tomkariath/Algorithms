package dataStructures;

public class MinHeap {
    Node root;

    //insertion
    public void insert(int newElement){
        Node newNode = new Node(newElement);
        if (root == null){
            root = newNode;
        }
        else {
            insert(root, new Node(newElement));
        }
    }

    private void insert (Node node, Node newNode) {
        if (node.leftChild == null){
            newNode.parent = node;
            node.leftChild = newNode;

            swim(newNode);
        } else if (node.rightChild == null) {
            newNode.parent = node;
            node.rightChild = newNode;

            swim(newNode);
        }
        else if (isNotFilled(node.leftChild)){
            insert(node.leftChild, newNode);
        } else if (isNotFilled(node.rightChild)) {
            insert(node.rightChild, newNode);
        }
        else {
            insert(node.leftChild, newNode);
        }
    }

    private boolean isNotFilled(Node node){
        return node.leftChild == null || node.rightChild == null;
    }

    //swim
    private void swim (Node node){
        if (node.parent == null){
            return;
        }

        if (node.element < node.parent.element) {
            swap(node.parent, node);
        }
        swim(node.parent);
    }

    //swap
    private void swap (Node node1, Node node2){
        int temp = node1.element;
        node1.element = node2.element;
        node2.element = temp;
    }

    public void printMin(){
        System.out.println(getMin());
    }

    public int getMin(){
        return root.element;
    }

    public void printTree(){
        printTree(root);
        System.out.println("----------------------");
    }

    private void printTree(Node node){
        if (node.rightChild == null && node.leftChild == null){
            System.out.print(node.element+"->");
            System.out.println();
            return;
        }
        System.out.print(node.element+"->");
        if (node.leftChild != null){
            System.out.print(node.leftChild.element+"=");
        }
        if (node.rightChild != null) {
            System.out.print(node.rightChild.element);
        }

        System.out.println();

        if (node.leftChild != null){
            printTree(node.leftChild);
        }
        if (node.rightChild != null) {
            printTree(node.rightChild);
        }
    }

    //deleteMin
    public void deleteMin(){
        if (root == null){
            return;
        }

       //printTree();

        Node lastNode = getLastChild();
        root.element = lastNode.element;

        //System.out.println(lastNode.element);

        //rightChild, if exists, is always last
        if (lastNode.parent.rightChild != null){
            lastNode.parent.rightChild = null;
        }
        else {
            lastNode.parent.leftChild = null;
        }

        sink(root);
    }

    //sink
    private void sink(Node node){
        //right is filled only after left
        if (node.leftChild == null){
            return;
        }

        if (node.element > node.leftChild.element){
            swap(node, node.leftChild);
            sink(node.leftChild);
        }

        if ( node.rightChild!= null && node.element > node.rightChild.element){
            swap(node, node.rightChild);
            sink(node.rightChild);
        }
    }

    //getLastChild
    private Node getLastChild(){
        return getLastChild(root);
    }

    private Node getLastChild(Node node){
        if (node == null){
            return null;
        }

        if (node.rightChild == null && node.leftChild == null){
            return node;
        }

        if (node.rightChild == null){
            return getLastChild(node.leftChild);
        }
        if (!hasChildren(node.rightChild) && hasChildren(node.leftChild)){
            return getLastChild(node.leftChild);
        }

        return getLastChild(node.rightChild);
    }

    private boolean hasChildren(Node node){
        return node.leftChild != null || node.rightChild != null;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        //minHeap.printTree();
        minHeap.insert(5);
        //minHeap.printTree();
        minHeap.insert(3);
        //minHeap.printTree();
        minHeap.insert(2);
        //minHeap.printTree();
        minHeap.insert(4);
        minHeap.insert(6);

        minHeap.printMin();
        minHeap.printTree();
        minHeap.deleteMin();

        minHeap.printMin();
        minHeap.printTree();
        minHeap.deleteMin();

        minHeap.printMin();
        minHeap.printTree();
        minHeap.deleteMin();

        minHeap.printMin();
        minHeap.printTree();

    }

    private static class Node {
        int element;
        Node leftChild;
        Node rightChild;
        Node parent;

        Node (int element){
            this.element = element;
            leftChild = null;
            rightChild = null;
            parent = null;
        }
    }
}
