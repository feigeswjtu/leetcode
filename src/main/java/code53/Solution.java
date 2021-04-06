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
        int[] maxArray = new int[nums.length];
        maxArray[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (maxArray[i - 1] >= 0) {
                    maxArray[i] = maxArray[i - 1] + nums[i];
                }else {
                    maxArray[i] =nums[i];
                }
            } else {
                if (maxArray[i - 1] < 0) {
                    maxArray[i] = nums[i];
                } else {
                    maxArray[i] = maxArray[i - 1] + nums[i];
                }
            }
            max = Math.max(max, maxArray[i]);
        }
        return max;
    }

    /**
     * 单指针实现
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
        }
        return max;
    }
}
