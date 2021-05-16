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

        // 二分法查找
        // 左索引
        int leftIndex = 0;

        // 右索引
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            // 中间节点
            int midIndex = (leftIndex + rightIndex) / 2;
            // 如果找到直接返回
            if (target == nums[midIndex]) {
                return midIndex;
            }
            // 如果找到直接返回
            if (target == nums[leftIndex]) {
                return leftIndex;
            }
            // 如果找到直接返回
            if (target == nums[rightIndex]) {
                return rightIndex;
            }

            // 如果目标值小于中间
            if (target < nums[midIndex]) {
                // 如果中间值大于左值
                if (nums[midIndex] >= nums[leftIndex]) {
                    // 如果目标值大于等于左边值
                    if (target >= nums[leftIndex]) {
                        rightIndex = midIndex - 1;
                    } else {
                        leftIndex = midIndex + 1;
                    }
                } else {
                    rightIndex = midIndex - 1;
                }

            } else {
                // 如果中间值大于左值
                if (nums[midIndex] >= nums[leftIndex]) {
                    leftIndex = midIndex + 1;
                } else {
                    // 如果目标值大于等于右值
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
