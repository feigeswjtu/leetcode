package code42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-25 22:44 feigeswjtu.cyf Exp $$
 */
class Solution {
    public int trap(int[] height) {
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < height.length; i++) {
            // 队列为空时，前面的高度都为0
            if (deque.isEmpty() && height[i] == 0) {
                continue;
            }

            if (deque.isEmpty()) {
                deque.push(i);
                continue;
            }


            Integer leftIndex = deque.peek();

            if (height[i] <= height[leftIndex]) {
                deque.push(i);
                continue;
            }

            int midHeight = height[i];
            while (!deque.isEmpty()) {

                leftIndex = deque.peek();

                if (height[i] < height[leftIndex]){
                    result += (height[i] - midHeight) * (i - leftIndex - 1);
                    break;
                }

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