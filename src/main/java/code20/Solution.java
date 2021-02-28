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
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if (leftValidCharMap.containsKey(c)) {
                deque.push(c);
                continue;
            }

            if (rightValidCharMap.containsKey(c)) {
                if (deque.isEmpty()) {
                    return false;
                }
                Character pop = deque.pop();
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
