package problems;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceBetweenTreeNodes {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(4);
        tree.insert(1);
        tree.insert(3);
        tree.insert(9);
        tree.insert(6);
        tree.insert(8);
        tree.insert(7);

        tree.displayInorder();
        System.out.println(tree.distanceBetweenNodes(1,3));
    }

    private static class Tree {

        TreeNode root;
        boolean isLCAFound;

        public void insert(int value){
            if (root == null){
                root = new TreeNode(value);
                return;
            }

            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);

            while (nodeQueue.size()>0){
                TreeNode node = nodeQueue.poll();

                if (node.leftChild==null){
                    node.leftChild = new TreeNode(value);
                    return;
                }
                nodeQueue.add(node.leftChild);

                if (node.rightChild==null){
                    node.rightChild = new TreeNode(value);
                    return;
                }
                nodeQueue.add(node.rightChild);
            }
        }

        private TreeNode findLCA(TreeNode node1, TreeNode node2){
            return findLCA(root, node1, node2);
        }

        private TreeNode findLCA(TreeNode currentNode, TreeNode node1, TreeNode node2){
            if (currentNode == null){
                return null;
            }

            if (currentNode.equals(node1) || currentNode.equals(node2)){
                isLCAFound = true;
                return currentNode;
            }

            TreeNode leftResult = findLCA(currentNode.leftChild, node1, node2);
            TreeNode rightResult = findLCA(currentNode.rightChild, node1, node2);

            if (leftResult!=null && rightResult!=null){
                isLCAFound = true;
                return currentNode;
            }

            if (isLCAFound){
                if (leftResult!=null){
                    return leftResult;
                }
                else {
                    return rightResult;
                }
            }

            return null;
        }

        public void displayInorder(){
            displayInorder(root);
            System.out.println();
        }

        private void displayInorder(TreeNode node){
            if (node==null){
                return;
            }

            displayInorder(node.leftChild);
            if (node.equals(root)){
                System.out.print("["+node+"]");
            }
            else {
                System.out.print(node);
            }
            displayInorder(node.rightChild);
        }

        public int distanceBetweenNodes(int value1, int value2){
            return distanceBetweenNodes(new TreeNode(value1), new TreeNode(value2));
        }

        private int distanceBetweenNodes(TreeNode node1, TreeNode node2){
           TreeNode ancestor = findLCA(node1, node2);
           return distanceFromAncestor(ancestor, node1) + distanceFromAncestor(ancestor, node2);
        }

        private int distanceFromAncestor(TreeNode ancestor, TreeNode node){
            if (ancestor == null){
                return -1;
            }

            if (ancestor.equals(node)){
                return 0;
            }

            int leftValue = distanceFromAncestor(ancestor.leftChild, node);
            int rightValue = distanceFromAncestor(ancestor.rightChild, node);

            if (leftValue!=-1){
                return 1 + leftValue;
            }

            if (rightValue!=-1) {
                return 1 + rightValue;
            }

            return -1;
        }

        private static class TreeNode {
            int value;
            TreeNode leftChild;
            TreeNode rightChild;

            public TreeNode(int value){
                this.value = value;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof TreeNode){
                    return this.value == ((TreeNode) obj).value;
                }
                return false;
            }

            @Override
            public String toString() {
                return String.valueOf(value);
            }
        }
    }
}
