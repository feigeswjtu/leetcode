package code33;

/**
 * 搜索旋转排序数组
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (target == nums[midIndex]) {
                return midIndex;
            }
            if (target == nums[leftIndex]) {
                return leftIndex;
            }
            if (target == nums[rightIndex]) {
                return rightIndex;
            }

            if (target < nums[midIndex]) {
                if (nums[midIndex] >= nums[leftIndex]) {
                    if (target >= nums[leftIndex]) {
                        rightIndex = midIndex - 1;
                    } else {
                        leftIndex = midIndex + 1;
                    }
                } else {
                    rightIndex = midIndex - 1;
                }

            } else {
                if (nums[midIndex] >= nums[leftIndex]) {
                    leftIndex = midIndex + 1;
                } else {
                    if (target >= nums[leftIndex]) {
                        rightIndex = midIndex - 1;
                    } else {
                        leftIndex = midIndex + 1;
                    }
                }
            }
        }

        return -1;
    }
}
