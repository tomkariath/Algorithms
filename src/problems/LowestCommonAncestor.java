package problems;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(3);
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(2);
        tree.insert(0);
        tree.insert(8);
        tree.insert(7);
        tree.insert(4);

        tree.displayInorder();

        tree.findLCA(4, 7);
    }

    private static class Tree {

        TreeNode root;
        boolean isLCAFound;

        public void findLCA(int node1, int node2){
            isLCAFound = false;
            if (node2 == node1){
                System.out.println(node1);
            }

            System.out.println(findLCA(root, node1, node2));
        }

        private int findLCA(Tree.TreeNode node, int node1, int node2){
            if (node==null){
                return -1;
            }

            if (node.value == node1 || node.value == node2){
                return node.value;
            }

            int leftResult = findLCA(node.leftChild, node1, node2);
            int rightResult = findLCA(node.rightChild, node1, node2);

            if (leftResult!=-1 && rightResult!=-1){
                isLCAFound = true;
                return node.value;
            }

            if (isLCAFound){
                if (leftResult!=-1){
                    return leftResult;
                }
                else {
                    return rightResult;
                }
            }
            return -1;
        }

        public void displayInorder(){
            displayInorder(root);
            System.out.println();
        }

        private void displayInorder(TreeNode node){
            if (node == null){
                return;
            }
            displayInorder(node.leftChild);
            if (node == root){
                System.out.print("["+node.value+"]");
            }
            else {
                System.out.print(node.value);
            }
            displayInorder(node.rightChild);
        }

        public void insert(int value) {
            if (root == null){
                root = new TreeNode(value);
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (queue.size() > 0){
                TreeNode temp = queue.poll();

                if (temp.leftChild == null){
                    temp.leftChild = new TreeNode(value);
                    return;
                }
                queue.add(temp.leftChild);

                if (temp.rightChild == null){
                    temp.rightChild = new TreeNode(value);
                    return;
                }
                queue.add(temp.rightChild);
            }
        }

        private static class TreeNode {
            int value;
            TreeNode leftChild;
            TreeNode rightChild;

            public TreeNode (int value){
                this.value = value;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof TreeNode){
                    return this.value == ((TreeNode) obj).value;
                }
                return false;
            }
        }
    }
}
