package code205;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 * 
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map1.containsKey(a)) {
                char pre = map1.get(a);
                if (pre != b) {
                    return false;
                }
            } else {
                map1.put(a, b);
            }

            if (map2.containsKey(b)) {
                char pre = map2.get(b);
                if (pre != a) {
                    return false;
                }
            } else {
                map2.put(b, a);
            }
        }

        return true;
    }
}
