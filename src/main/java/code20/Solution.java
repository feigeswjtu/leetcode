package code20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    Map<Character, Character> leftValidCharMap = new HashMap<>();
    Map<Character, Character> rightValidCharMap = new HashMap<>();

    // 初始化映射关系
    {
        leftValidCharMap.put('(', ')');
        leftValidCharMap.put('{', '}');
        leftValidCharMap.put('[', ']');

        rightValidCharMap.put(')', '(');
        rightValidCharMap.put('}', '{');
        rightValidCharMap.put(']', '[');

    }

    public boolean isValid(String s) {

        if (s.isEmpty()) {
            return false;
        }

        int length = s.length();
        // 声明栈
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            // 左边的放入栈
            if (leftValidCharMap.containsKey(c)) {
                deque.push(c);
                continue;
            }

            // 遇到右边的括号和栈顶的做对比
            if (rightValidCharMap.containsKey(c)) {
                // 如果队列为空则返回false
                if (deque.isEmpty()) {
                    return false;
                }
                Character pop = deque.pop();
                // 如果栈顶的元素和当前元素配对，则继续
                if (leftValidCharMap.get(pop).equals(c)) {
                    continue;
                } else {
                    return false;
                }
            }
            return false;
        }

        return deque.isEmpty();


    }
}
