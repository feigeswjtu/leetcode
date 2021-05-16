package code209;

/**
 * 长度最小的子数组
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 双指针法
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {

        // 左指针
        int leftIndex = 0;
        // 右指针
        int rightIndex = 0;
        int sum = 0;
        // 定义最大值
        int maxLength = Integer.MAX_VALUE;
        while (rightIndex < nums.length) {
            sum += nums[rightIndex];

            // 如果和大于目标结果，则左指针右移
            while (sum >= target && leftIndex < nums.length) {
                int length = (rightIndex - leftIndex + 1);
                maxLength = Math.min(maxLength, length);
                sum -= nums[leftIndex];
                leftIndex++;
            }
            rightIndex++;
        }

        return maxLength == Integer.MAX_VALUE ? 0 : maxLength;
    }

}
