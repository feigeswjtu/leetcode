package code16;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
//    public int threeSumClosest(int[] nums, int target) {
//        if (nums.length < 3) {
//            return 0;
//        }
//
//        Arrays.sort(nums);
//
//        int result = 10 * 10 * 10 * 10;
//        int leftIndex = 0;
//        int rightIndex = nums.length - 1;
//
//        while (leftIndex + 1 < rightIndex) {
//            for (int i = leftIndex + 1; i < rightIndex; i++) {
//                int sumValue = nums[leftIndex] + nums[rightIndex] + nums[i];
//                if (sumValue - target == 0) {
//                    return sumValue;
//                }
//
//
//                if (Math.abs(sumValue - target) < Math.abs(result - target)) {
//                    result = sumValue;
//                }
//            }
//
//            if (result < target) {
//                leftIndex++;
//            } else {
//                rightIndex--;
//            }
//        }
//
//        return result;
//    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

}
