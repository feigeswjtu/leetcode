package code84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length+2];

        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        newHeights[heights.length + 1] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        int result = 0;

        deque.push(0);

        for (int i = 1; i < newHeights.length; i++) {
            int currentHeight = newHeights[i];
            while (currentHeight < newHeights[deque.peekLast()]){
                int height = newHeights[deque.pollLast()];
                int width = i - deque.peekLast() - 1;
                result = Math.max(result, height * width);
            }
            deque.addLast(i);

        }

        return result;

    }
}
