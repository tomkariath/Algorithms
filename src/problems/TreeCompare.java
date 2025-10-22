package problems;


class TreeNode {
    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value, TreeNode leftChild, TreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}

public class TreeCompare {

    public static void main (String[] args) {
        TreeNode tree1 = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));

        TreeNode tree2 = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));

        TreeCompare comparer = new TreeCompare();
        boolean result = comparer.isSameTree(tree1, tree2);
        System.out.println("Are the two trees identical? " + result);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        return preorderComparison(p, q);
    }

    private boolean preorderComparison(TreeNode p, TreeNode q) {
        if (p== null && q==null){
            return true;
        }

        if (p== null || q==null){
            return false;
        }

        if (p.value != q.value){
            return false;
        }

        return preorderComparison (p.leftChild, q.leftChild) && preorderComparison (p.rightChild, q.rightChild);
    }
}