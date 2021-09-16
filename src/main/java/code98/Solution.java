package code98;

/**
 * 验证二叉搜索树
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 通过入参来判断最大值和最小值
     * @param root
     * @return
     */
    public boolean isValidBSTV2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return bst(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean bst(TreeNode root, long maxValue, long minValue) {
        if (root == null) {
            return true;
        }

        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }

        return bst(root.left, root.val, minValue) && bst(root.right, maxValue, root.val);
    }

    /**
     * 最大值和最小值通过对象临时保存
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }


        boolean isValidBST = true;

        if (root.right != null) {
            isValidBST = isValidBST && root.val < root.right.val;
            ValidBSTObject rightValidBSTObject = validBST(root.right);
            isValidBST = isValidBST && rightValidBSTObject.isValidBST && rightValidBSTObject.minValue > root.val;

        }

        if (root.left != null) {
            isValidBST = isValidBST && root.val > root.left.val;
            ValidBSTObject leftValidBSTObject = validBST(root.left);
            isValidBST = isValidBST && leftValidBSTObject.isValidBST && leftValidBSTObject.maxValue < root.val;
        }
        return isValidBST;

    }

    private ValidBSTObject validBST(TreeNode root) {
        int minValue = root.val;
        int maxValue = root.val;
        boolean isValidBST = true;

        if (root.right != null) {
            isValidBST = isValidBST && root.val < root.right.val;
            ValidBSTObject rightValidBSTObject = validBST(root.right);
            minValue = Math.min(minValue, rightValidBSTObject.minValue);
            maxValue = Math.max(maxValue, rightValidBSTObject.maxValue);
            isValidBST = isValidBST && rightValidBSTObject.isValidBST && rightValidBSTObject.minValue > root.val;
        }

        if (root.left != null) {
            isValidBST = isValidBST && root.val > root.left.val;
            ValidBSTObject leftValidBSTObject = validBST(root.left);
            minValue = Math.min(minValue, leftValidBSTObject.minValue);
            maxValue = Math.max(maxValue, leftValidBSTObject.maxValue);
            isValidBST = isValidBST && leftValidBSTObject.isValidBST && leftValidBSTObject.maxValue < root.val;
        }


        return new ValidBSTObject(isValidBST, minValue, maxValue);
    }
}

class ValidBSTObject {
    public ValidBSTObject() {
    }

    public ValidBSTObject(boolean isValidBST, int minValue, int maxValue) {
        this.isValidBST = isValidBST;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    boolean isValidBST;
    int minValue;
    int maxValue;
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
