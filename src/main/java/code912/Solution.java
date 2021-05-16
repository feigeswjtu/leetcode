package code912;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param i
     * @param j
     */
    private void quickSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int patition = patition(nums, i, j);
        quickSort(nums, i, patition - 1);
        quickSort(nums, patition + 1, j);
    }

    /**
     * 找到位置
     *
     * @param nums
     * @param i
     * @param j
     * @return
     */
    private int patition(int[] nums, int i, int j) {
        int patitionValue = nums[i];
        while (i < j) {
            while (nums[j] <= patitionValue && j > i) {
                j--;
            }
            nums[i] = nums[j];

            while (nums[i] >= patitionValue && j > i) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = patitionValue;

        return i;
    }
}
