package code236;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 二叉树的最近公共祖先
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        AtomicReference<TreeNode> reference = new AtomicReference<TreeNode>();
        dfs(reference, root, p, q);
        return reference.get();
    }

    boolean dfs(AtomicReference<TreeNode> reference, TreeNode root, TreeNode p, TreeNode q){

        if (root == null) return false;
        boolean lson = dfs(reference, root.left, p, q);
        boolean rson = dfs(reference, root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
             reference.set(root);
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}