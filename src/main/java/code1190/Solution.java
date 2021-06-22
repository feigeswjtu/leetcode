package code1190;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 反转每对括号间的子串
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public String reverseParentheses(String s) {
        int length = s.length();
        int count = 0;
        Deque<Character> deque1 = new ArrayDeque<>();
        Deque<Character> deque2 = new ArrayDeque<>();
        for (int i = length - 1; i > 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                count++;
                moveToOtherDeque(deque1, deque2);
            } else if (c == '(') {
                count--;
                moveToOtherDeque(deque2, deque1);
            } else {
                if (count % 2 == 1) {
                    moveToOtherDeque(deque1, deque2);
                    deque2.push(c);
                } else {
                    moveToOtherDeque(deque2, deque1);
                    deque1.push(c);
                }
            }
        }

        Deque<Character> deque;

        if (count % 2 == 1) {
            moveToOtherDeque(deque1, deque2);
            deque = deque2;
        } else {
            moveToOtherDeque(deque2, deque1);
            deque = deque1;
        }

        StringBuilder resultBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            Character pop = deque.pop();
            if (pop != '(' && pop != ')') {
                resultBuilder.append(pop);
            }
        }

        return resultBuilder.toString();
    }

    private void moveToOtherDeque(Deque<Character> deque1, Deque<Character> deque2) {
        while (!deque1.isEmpty()) {
            deque2.push(deque1.pop());
        }
    }
}
