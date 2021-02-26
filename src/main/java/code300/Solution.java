package code300;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-25 22:44 feigeswjtu.cyf Exp $$
 */
class Solution {
    public int lengthOfLIS(int[] arrays) {
        int maxLength = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < arrays.length; i++) {
            if (deque.isEmpty()) {
                deque.push(arrays[i]);
                maxLength = 1;
                continue;
            }

            while (!deque.isEmpty()) {
                Integer leftValue = deque.peek();
                if (arrays[i] > leftValue) {
                    break;
                } else if (arrays[i] < leftValue) {
                    deque.pop();
                } else {
                    break;
                }
            }
            deque.push(arrays[i]);
            maxLength = Math.max(maxLength, deque.size());
        }
        return maxLength;
    }
}