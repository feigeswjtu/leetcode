package code897;

/**
 * 递增顺序搜索树
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    private TreeNode result = null;
    private TreeNode temp = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        result = new TreeNode();
        temp = result;


        midBST(root);
        return result.right;
    }

    public void midBST(TreeNode root) {
        if (root == null) {
            return;
        }

        midBST(root.left);
        temp.right = new TreeNode();
        temp.right.val = root.val;
        temp = temp.right;
        midBST(root.right);
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
