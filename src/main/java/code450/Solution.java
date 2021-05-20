package code450;

/**
 * 删除二叉搜索树中的节点
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /*
     * 找到以某个结点为根节点的右子树最小值。
     **/
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
     * 找到以某个结点为根节点的左子树最大值。
     **/
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // 递归终止条件
        if (root == null) {
            return null;
        }

        // 如果查找的结点比根节点大，继续在右子树查找删除该结点
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // 如果查找的结点比根节点小，继续在左子树查找删除该结点
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            // 如果找到了该结点，删除它
        } else {
            // 如果这个节点是叶子节点，以叶子节点为根节点的二叉搜索树只有一个元素，可以直接删除。
            if (root.left == null && root.right == null) root = null;
                // 如果有右子树，只要找到该右子树的最小值来替换，之后将它删除即可。
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // 如果有左子树，只要找到该左子树的最大值来替换，之后将它删除即可。
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
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