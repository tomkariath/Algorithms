package dataStructures;

public class SumTreeNode extends TreeNode{
    private SumTreeNode parent;
    private int sum;

    public SumTreeNode(int value) {
        super(value);
        sum = value;
        parent = null;
    }

    public void setLeftChild(SumTreeNode leftChild) {
        super.setLeftChild(leftChild);
        if (leftChild != null) {
            leftChild.parent = this;
            setSum(this, leftChild.getValue());
        }
    }

    public void setRightChild(SumTreeNode rightChild) {
        super.setRightChild(rightChild);
        if (rightChild != null) {
            rightChild.parent = this;
            setSum(this, rightChild.getValue());
        }
    }

    private static void setSum(SumTreeNode node, int value){
        node.sum = node.sum+value;
        if (node.parent != null){
            setSum(node.parent, value);
        }
    }

    public static void displayTree(SumTreeNode root) {
        if (root.getLeftChild() != null)
            displayTree((SumTreeNode) root.getLeftChild());
        System.out.print("(" + root.getValue() + " " + root.sum + ")");
        if (root.getRightChild() != null)
            displayTree((SumTreeNode)root.getRightChild());
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }
}
