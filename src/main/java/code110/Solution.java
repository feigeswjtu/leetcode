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
        if (root == null) {
            return true;
        }

        // 临时存储
        AtomicBoolean isBalance = new AtomicBoolean(true);

        // 看左边的高度
        int leftHeight = getTreeHeight(root.left, isBalance);

        // 看右边的高度
        int rightHeight = getTreeHeight(root.right, isBalance);
        // 最终结果
        return isBalance.get() && Math.abs(leftHeight - rightHeight) <= 1;
    }

    private int getTreeHeight(TreeNode root, AtomicBoolean isBalance) {
        if (root == null) {
            return 0;
        }

        // 看左边的高度
        int leftHeight = getTreeHeight(root.left, isBalance);
        // 看右边的高度
        int rightHeight = getTreeHeight(root.right, isBalance);

        // 如果左右高度大于1设置为false
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalance.set(false);
        }
        // 返回高度+1
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
