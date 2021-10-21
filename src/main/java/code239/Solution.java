package code239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        // 从大到小排列
        Deque<Integer> windowsDeque = new LinkedList<>();

        // 结果数组
        int[] result = new int[nums.length - k + 1];

        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 处理队列，保证队列里的数据都是从大到小排列
            while (!windowsDeque.isEmpty() && nums[windowsDeque.peekLast()] < nums[i]) {
                windowsDeque.pollLast();
            }
            // 把下标房放入队列中
            windowsDeque.addLast(i);

            // 如何最前面的下标不在窗口内，直接弹出
            if (windowsDeque.peekFirst() < i - k + 1) {
                windowsDeque.pollFirst();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[windowsDeque.peekFirst()];
            }
        }
        return result;
    }
}
