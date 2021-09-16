package code1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-25 22:29 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 双层循环
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // 输入数组为null
        if (nums == null) {
            return result;
        }

        // 输入数组长度为1
        if (nums.length == 1) {
            return result;
        }


        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                // 找到和为目标结果
                if (nums[result[0]] + nums[j] == target) {
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;

    }

    /**
     * 时间换空间
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV2(int[] nums, int target) {
        int[] result = new int[2];
        // 输入数组为null
        if (nums == null) {
            return result;
        }

        // 输入数组长度为1
        if (nums.length == 1) {
            return result;
        }


        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer subValueIndex = map.get(target - nums[i]);
            if (subValueIndex != null) {
                result[0] = i;
                result[1] = subValueIndex;
            } else {
                map.put(nums[i], i);
            }

        }

        return result;

    }

    /**
     * 排序，思路正确，但是因为返回的是下标，所以结果不正确
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV3(int[] nums, int target) {
        int[] result = new int[2];
        // 输入数组为null
        if (nums == null) {
            return result;
        }

        // 输入数组长度为1
        if (nums.length == 1) {
            return result;
        }

        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int num = nums[i] + nums[j];
            if (num < target) {
                i++;
            } else if (num > target) {
                j--;
            } else {
                result[0] = i;
                result[1] = j;
                break;
            }
        }

        return result;
    }
}
