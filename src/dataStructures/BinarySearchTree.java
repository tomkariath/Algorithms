package dataStructures;

public class BinarySearchTree {

    Node root;

    //insertion
    public void insert (int value){
        root = insert(root, value);
    }

    private Node insert (Node node, int value){

        if (node == null){
            node = new Node(value);
        }
        else {
            if (node.value > value){
                node.left = insert(node.left, value);
                node.height = calculateHeight(node);
            }
            else if ((node.value < value)){
                node.right = insert(node.right, value);
                node.height = calculateHeight(node);
            }
        }

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

    private static class Node {
        int value;
        int height;

        Node right;
        Node left;

        Node(int value) {
            this.value = value;
            height = 0;
        }


    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        //1, 8, 16, 10, 11, 4
        //15, 10, 4, 18, 14, 9
        
        bst.insert(15);
        bst.insert(10);
        bst.insert(4);
        bst.insert(18);
        bst.insert(14);
        bst.insert(9);

        bst.printTree();
    }
}
