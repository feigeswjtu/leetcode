package code15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }

        // 先排序
        Arrays.sort(nums);

        int length = nums.length;

        // 最左边的数字固定，移动后后面的两个数字
        for (int i = 0; i < length; i++) {
            // 如果最左边的数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = length - 1;
            // 移动后面的两个数字
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    // 去重
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return result;
    }

}
