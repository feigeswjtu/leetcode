package code53;

/**
 * 最大子序和
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 动态规划实现
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        // 每个数字的最大值
        int[] maxArray = new int[nums.length];
        // 第一个值为第一个元素的值
        maxArray[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 当前值小于0时
            if (nums[i] < 0) {
                // 如果前一个值>=0
                if (maxArray[i - 1] >= 0) {
                    maxArray[i] = maxArray[i - 1] + nums[i];
                } else {
                    maxArray[i] = nums[i];
                }
            } else {
                // 如果前一个值<0
                if (maxArray[i - 1] < 0) {
                    maxArray[i] = nums[i];
                } else {
                    maxArray[i] = maxArray[i - 1] + nums[i];
                }
            }
            // 返回最大值
            max = Math.max(max, maxArray[i]);
        }
        return max;
    }
}
