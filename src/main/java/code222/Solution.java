package code222;

/**
 * 完全二叉树的节点个数
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevelCount = levelCount(root.left);
        int rightLevelCount = levelCount(root.right);
        if (leftLevelCount == rightLevelCount) {
            return countNodes(root.right) + (1 << leftLevelCount);
        } else {
            return countNodes(root.left) + (1 << rightLevelCount);
        }

    }

    /**
     * 层高
     * 
     * @param root
     * @return
     */
    private int levelCount(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }

        return count;

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
