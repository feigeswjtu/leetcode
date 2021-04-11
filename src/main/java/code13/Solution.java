package code13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    private Map<String, Integer> romanToValue = new HashMap<>();

    {
        romanToValue.put("I", 1);
        romanToValue.put("IV", 4);
        romanToValue.put("V", 5);
        romanToValue.put("IX", 9);
        romanToValue.put("X", 10);
        romanToValue.put("XL", 40);
        romanToValue.put("L", 50);
        romanToValue.put("XC", 90);
        romanToValue.put("C", 100);
        romanToValue.put("CD", 400);
        romanToValue.put("D", 500);
        romanToValue.put("CM", 900);
        romanToValue.put("M", 1000);

    }

    public int romanToInt(String s) {
        int length = s.length();
        int sIndex = 0;
        int value = 0;

        while (sIndex < length) {
            if (sIndex + 2 <= length) {

                String substring = s.substring(sIndex, sIndex + 2);
                if (romanToValue.containsKey(substring)) {
                    value += romanToValue.get(substring);
                    sIndex += 2;
                    continue;
                }
            }

            if (sIndex + 1 <= length) {
                String substring = s.substring(sIndex, sIndex + 1);
                if (romanToValue.containsKey(substring)) {
                    value += romanToValue.get(substring);
                    sIndex += 1;
                }
            }
        }

        return value;
    }
}
