package code110;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 平衡二叉树
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        AtomicBoolean isBalance = new AtomicBoolean(true);

        int leftHeight = getTreeHeight(root.left,isBalance);
        int rightHeight = getTreeHeight(root.right, isBalance);
        return isBalance.get() && Math.abs(leftHeight - rightHeight) <= 1;
    }

    private int getTreeHeight(TreeNode root, AtomicBoolean isBalance){
        if (root == null){
            return 0;
        }

        int leftHeight = getTreeHeight(root.left,isBalance);
        int rightHeight = getTreeHeight(root.right, isBalance);

        if (Math.abs(leftHeight - rightHeight) > 1){
            isBalance.set(false);
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
