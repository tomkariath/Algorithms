package problems;

import dataStructures.SumTreeNode;
import dataStructures.TreeNode;

/**
 * Check if the tree can be partitioned equally - if a node and children (Edge) is seperated to a new tree, the resulting
 * trees have equal sum
 */

public class EqualTreePartition {

    int height;

    public static void main(String[] args) {
        SumTreeNode n1 = new SumTreeNode(5);
        SumTreeNode n2 = new SumTreeNode(10);
        SumTreeNode n3 = new SumTreeNode(10);
        SumTreeNode n4 = new SumTreeNode(2);
        SumTreeNode n5 = new SumTreeNode(3);

        n1.setLeftChild(n2);
        n1.setRightChild(n3);

        n2.setLeftChild(n4);
        n2.setRightChild(n5);

        SumTreeNode.displayTree(n1);
        System.out.println();
        int height = calculateHeight(n1);
        System.out.println(calculateHeight(n1));
        System.out.println(findEqualPartition(n1, calculateHeight(n1)));
    }

    private static SumTreeNode findEqualPartition(SumTreeNode root, int height){
        int partitionValue = root.getSum()/2;
        SumTreeNode node;
        for(int i=1; i<=height; i++){
            node = getNodesInLevel(root, i, partitionValue);
            if (node!=null){
                return node;
            }
        }

        return null;
    }

    private static SumTreeNode getNodesInLevel(SumTreeNode node, int height, int partitionValue){
        if(node == null){
            return null;
        }

        if (height==1 && node.getSum()==partitionValue){
            return node;
        }

        if (height > 1) {
            if(node.getLeftChild() != null){
                return getNodesInLevel((SumTreeNode) node.getLeftChild(), height-1, partitionValue);
            }

            if(node.getRightChild() != null){
                return getNodesInLevel((SumTreeNode) node.getRightChild(), height-1, partitionValue);
            }
        }

        return null;
    }

    private static int calculateHeight(TreeNode node){
        if (node == null){
            return 0;
        }

        return Math.max(calculateHeight(node.getLeftChild()), calculateHeight(node.getRightChild()))+1;
    }
}
