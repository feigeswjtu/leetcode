package code34;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums == null || nums.length == 0) {
            return result;
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (nums[midIndex] == target) {
                result[0] = findLeftIndex(nums, leftIndex, midIndex, target);

                result[1] = findRightIndex(nums, midIndex, rightIndex, target);
                break;
            }

            if (nums[midIndex] < target) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }

        return result;

    }


    private int findLeftIndex(int[] nums, int leftIndex, int rightIndex, int target) {
        int leftIndexResult = rightIndex;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;


            if (target == nums[midIndex]) {
                leftIndexResult = midIndex;
                rightIndex = midIndex - 1;
            } else {
                leftIndex = midIndex + 1;
            }
        }
        return leftIndexResult;
    }

    private int findRightIndex(int[] nums, int leftIndex, int rightIndex, int target) {
        int rightIndexResult = leftIndex;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;


            if (target == nums[midIndex]) {
                rightIndexResult = midIndex;
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }
        return rightIndexResult;

    }

}
