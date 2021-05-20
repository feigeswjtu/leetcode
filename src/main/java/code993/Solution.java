package code993;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    TreeNode xParent;
    int xDeepth = 0;
    boolean xFound = false;
    TreeNode yParent;
    int yDeepth = 0;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y){
            return false;
        }

        inorderTraversal(root.left, x, y, 1, root);
        inorderTraversal(root.right, x, y, 1, root);


        return xParent != yParent && xDeepth == yDeepth;
    }


    private void inorderTraversal(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (xFound && yFound) {
            return;
        }

        if (root.val == x) {
            xDeepth = depth;
            xFound = true;
            xParent = parent;
        }

        if (root.val == y) {
            yDeepth = depth;
            yFound = true;
            yParent = parent;
        }

        inorderTraversal(root.left, x, y, depth + 1, root);
        inorderTraversal(root.right, x, y, depth + 1, root);
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
