package code16;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int closestValue = Integer.MAX_VALUE;
        int minSub = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length - 1; i++) {
            int sumValue = nums[i - 1] + nums[i + 1] + nums[i];
            if (Math.abs(sumValue - target) < minSub) {
                minSub = Math.abs(sumValue -target);
                closestValue = sumValue;
            }
        }

        return closestValue;
    }


}
