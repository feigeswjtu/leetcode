package code42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 接雨水
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-25 22:44 feigeswjtu.cyf Exp $$
 */
class Solution {
    public int trap(int[] height) {
        int result = 0;
        // 定义一个队列，存储索引index
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < height.length; i++) {
            // 栈为空时，前面的高度都为0
            if (deque.isEmpty() && height[i] == 0) {
                continue;
            }

            if (deque.isEmpty()) {
                deque.push(i);
                continue;
            }


            Integer leftIndex = deque.peek();

            // 如果当前柱子高度小于右边的高度则放入队列
            if (height[i] <= height[leftIndex]) {
                deque.push(i);
                continue;
            }

            int midHeight = height[i];

            // 处理栈
            while (!deque.isEmpty()) {

                // 获取一个值
                leftIndex = deque.peek();

                // 如果当前柱子高度小于队列中取出的高度时
                if (height[i] < height[leftIndex]) {
                    result += (height[i] - midHeight) * (i - leftIndex - 1);
                    break;
                }

                // 栈中弹出
                leftIndex = deque.pop();

                if (midHeight > height[leftIndex]) {
                    midHeight = height[leftIndex];
                    continue;
                }

                result += (height[leftIndex] - midHeight) * (i - leftIndex - 1);
                midHeight = height[leftIndex];
            }
            deque.push(i);
        }
        return result;
    }
}