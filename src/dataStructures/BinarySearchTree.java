package dataStructures;

public class BinarySearchTree {

    Node root;

    //insertion
    public void insert (int value){
        root = insert(null, root, value);
    }

    private Node insert (Node parent, Node node, int value){

        if (node == null){
            node = new Node(value);
        }
        else {
            if (node.value > value){
                node.left = insert(node, node.left, value);
                node.height = calculateHeight(node);
            }
            else if ((node.value < value)){
                node.right = insert(node, node.right, value);
                node.height = calculateHeight(node);
            }
        }

        node.parent = parent;

        return node;
    }

    private int calculateHeight(Node node){
        if (node.right == null && node.left == null){
            return 0;
        }

        if (node.left == null){
            return node.right.height+1;
        }

        if (node.right == null){
            return node.left.height+1;
        }

        return Math.max(node.right.height, node.left.height) + 1;

    }

    public void printTree(){
        printTree(root);
        System.out.println("----------------------");
    }

    private void printTree(Node node){
        if (node.right == null && node.left == null){
            System.out.print(node.value +"("+ node.height+")"+"->");
            System.out.println();
            return;
        }
        System.out.print(node.value +"("+ node.height+")"+"->");
        if (node.left != null){
            System.out.print(node.left.value+"=");
        }
        if (node.right != null) {
            System.out.print(node.right.value);
        }

        System.out.println();

        if (node.left != null){
            printTree(node.left);
        }
        if (node.right != null) {
            printTree(node.right);
        }
    }

    //deletion
    public boolean delete (int value) {
        if (root.value == value){
            delete(root, true);
            root.height = calculateHeight(root);
            return true;
        }

        Node node = getNode(root, value);

        if (node == null){
            return false;
        }

        if (node.left.value == value){
            delete(node.left, true);
        }

        else if (node.right.value == value){
            delete(node.right, false);
        }

        return true;
    }

    private void recalculateHeight(Node node){
        if (node!=null){
            node.height = calculateHeight(node);
            recalculateHeight(node.parent);
        }
    }

    private void delete (Node node, boolean isLeft){
        if (node.right == null && node.left == null){
            if (node.parent == null){
                return;
            }

            if (isLeft){
                node.parent.left = null;
            }
            else {
                node.parent.right = null;
            }

            recalculateHeight(node.parent);

            return;
        }

        if (node.right == null){
            node.value = node.left.value;
            node.left = node.left.left;

            recalculateHeight(node);

            return;
        }

        if (node.left == null){
            node.value = node.right.value;
            node.right = node.right.right;

            recalculateHeight(node);

            return;
        }

        //find min successor
        if (node.right.left == null){
            node.value = node.right.value;
            node.right = node.right.right;

            recalculateHeight(node);
        }
        else {
            swapAndDeleteMinSuccessor(node, node.right);
        }
    }

    private void swapAndDeleteMinSuccessor(Node node, Node child){
        if (child.left.left == null){
            node.value = child.left.value;
            child.left = null;

            recalculateHeight(child);
        }
        else {
            swapAndDeleteMinSuccessor(node, child.left);
        }
    }

    private Node getNode (Node node, int value){

        if (node == null){
            return null;
        }

        if ((node.left != null && node.left.value == value) || (node.right != null && node.right.value == value)){
            return node;
        }

        if (node.value > value){
            return getNode(node.left, value);
        }

        if ((node.value < value)){
            return getNode(node.right, value);
        }

        return null;
    }

    public boolean isPresent(int value){
        return getNode(root, value) !=  null;
    }

    private static class Node {
        int value;
        int height;

        Node right;
        Node left;

        Node parent;

        Node(int value) {
            this.value = value;
            height = 0;
        }


    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        //1, 8, 16, 10, 11, 4
        //15, 10, 4, 18, 14, 9
        //3, 1, 5, 7, 15, 20, 2, 10, 14, 19
        
        bst.insert(15);
        bst.insert(10);
        bst.insert(4);
        bst.insert(18);
        bst.insert(8);
        bst.insert(16);
        bst.insert(10);
        bst.insert(11);
        bst.insert(4);
        bst.insert(3);
        bst.insert(1);
        bst.insert(5);
        System.out.println("10 ->"+bst.isPresent(10));

        bst.printTree();

        bst.delete(15);
        bst.printTree();
        bst.delete(10);
        bst.printTree();
        bst.delete(1);
        bst.printTree();
        bst.delete(8);
        bst.printTree();
        bst.delete(18);
        bst.printTree();
        bst.delete(16);
        System.out.println(bst.delete(22));
        bst.printTree();
        System.out.println("19 ->"+bst.isPresent(19));

        bst.insert(2);
        bst.insert(14);
        bst.insert(13);
        System.out.println("14 ->"+bst.isPresent(14));

        bst.printTree();
    }
}
