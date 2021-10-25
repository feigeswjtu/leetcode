package code109;

import common.ListNode;
import common.TreeNode;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode listNode) {
        if (listNode == null){
            return null;
        }

        ListNode temp = listNode;

        int length = 0;
        while (temp != null){
            length++;
            temp = temp.next;
        }

        int[] nums = new int[length];
        int index = 0;
        temp = listNode;
        while (temp != null){
            nums[index++] = temp.val;
            temp = temp.next;
        }

        if (nums.length == 0) {
            return null;
        }

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
