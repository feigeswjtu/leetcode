package common;

/**
 * @author feigeswjtu.cyf
 * @version $Id: TreeNode.java, v 0.1 2021-10-24 19:56 feigeswjtu.cyf Exp $$
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}