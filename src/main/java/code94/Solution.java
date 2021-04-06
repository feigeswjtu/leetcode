package code94;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(result, root);

        return result;
    }

    /**
     * 中序遍历
     * @param result
     * @param root
     */
    private void inorder(List<Integer> result, TreeNode root){
        if (root == null){
            return;
        }
        inorder(result, root.left);
        result.add(root.val);
        inorder(result, root.right);
    }

    /**
     * 前序遍历
     * @param result
     * @param root
     */
    private void preorder(List<Integer> result, TreeNode root){
        if (root == null){
            return;
        }
        result.add(root.val);
        preorder(result, root.left);
        preorder(result, root.right);
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

