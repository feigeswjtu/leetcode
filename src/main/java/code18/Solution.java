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
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 3) {
            int j = i + 1;
            while (j < nums.length - 2) {
                int left = j + 1;
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
                        while (nums[left] == leftValue && left < right) {
                            left++;
                        }
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

                while (nums[j] == jValue && j < nums.length - 2) {
                    j++;
                }
            }

            int iValue = nums[i];
            while (nums[i] == iValue && i < nums.length - 3) {
                i++;
            }
        }

        return result;
    }
}
