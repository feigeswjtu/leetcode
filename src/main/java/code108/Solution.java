package code108;

import common.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int length = nums.length;

        TreeNode node = new TreeNode();
        int mid = length / 2;
        node.val = nums[mid];

        node.left = buildBST(nums, 0, mid - 1);
        node.right = buildBST(nums, mid + 1, length - 1);

        return node;
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {

            TreeNode node = new TreeNode();
            node.val = nums[right];
            return node;
        }

        TreeNode node = new TreeNode();
        int mid = (left + right) / 2;
        node.val = nums[mid];

        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);

        return node;
    }
}
