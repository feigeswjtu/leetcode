package code80;

/**
 * 删除有序数组中的重复项 II
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    int process(int[] nums, int k) {
        int index = 0;
        for (int x : nums) {
            if (index < k || nums[index - k] != x)
                nums[index++] = x;
        }
        return index;
    }
}
