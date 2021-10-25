package code111;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null && root.right != null) {
            rightDepth = minDepth(root.right);
            leftDepth = minDepth(root.left);
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else {
            return minDepth(root.left) + 1;
        }

        return Math.min(rightDepth, leftDepth) + 1;

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
