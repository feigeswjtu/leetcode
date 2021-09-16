package code18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 先进行排序
        Arrays.sort(nums);
        int i = 0;
        // 固定第一个位置
        while (i < nums.length - 3) {
            int j = i + 1;
            // 固定第二个位置
            while (j < nums.length - 2) {

                // 第三和第四个位置使用双指针法，第三个位置从前面
                int left = j + 1;
                // 第四个位置从后面
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> targetArray = new ArrayList<>();
                        targetArray.add(nums[i]);
                        targetArray.add(nums[j]);
                        targetArray.add(nums[left]);
                        targetArray.add(nums[right]);
                        int leftValue = nums[left];
                        // 重复的值跳过
                        while (nums[left] == leftValue && left < right) {
                            left++;
                        }
                        // 重复的值跳过
                        int rightValue = nums[right];
                        while (nums[right] == rightValue && right > left) {
                            right--;
                        }
                        result.add(targetArray);
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

                int jValue = nums[j];

                // 重复的值跳过
                while (nums[j] == jValue && j < nums.length - 2) {
                    j++;
                }
            }

            int iValue = nums[i];
            // 重复的值跳过
            while (nums[i] == iValue && i < nums.length - 3) {
                i++;
            }
        }

        return result;
    }
}
