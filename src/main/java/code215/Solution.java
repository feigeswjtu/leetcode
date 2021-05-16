package code215;

/**
 * 数组中的第K个最大元素
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 堆排序实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        buildBigHeap(nums);
        int length = nums.length;

        for (int i = 0; i < k; i++) {
            swap(nums, 0, --length);
            heapSwitch(nums, 0, length);
        }


        return nums[length];
    }

    /**
     * 堆排序
     */
    private void buildBigHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; --i) {
            heapSwitch(nums, i, nums.length);
        }
    }


    /**
     * 构建大顶堆
     *
     * @param nums
     * @param i
     * @param n
     */
    private void heapSwitch(int[] nums, int i, int n) {
        int maxIndex = i;
        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        if (leftIndex < n && nums[leftIndex] > nums[maxIndex]) {
            maxIndex = leftIndex;
        }

        if (rightIndex < n && nums[rightIndex] > nums[maxIndex]) {
            maxIndex = rightIndex;
        }

        if (maxIndex != i) {
            swap(nums, maxIndex, i);
            heapSwitch(nums, maxIndex, n);
        }
    }

    /**
     * 交换
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
