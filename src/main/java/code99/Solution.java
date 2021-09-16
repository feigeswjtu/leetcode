package code99;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        /**
         * 通过入参来判断最大值和最小值
         * 
         * @param root
         * @return
         */
        if (root == null) {
            return;
        }

        bst(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean bst(TreeNode root, long maxValue, long minValue) {
        if (root == null) {
            return true;
        }

        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }

        return bst(root.left, root.val, minValue) && bst(root.right, maxValue, root.val);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
