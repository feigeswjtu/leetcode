package code12;

import java.util.HashMap;
import java.util.Map;

/**
 * 整数转罗马数字
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    private Map<Integer, String> valueToRoman = new HashMap();

    {
        valueToRoman.put(1, "I");
        valueToRoman.put(5, "V");
        valueToRoman.put(10, "X");
        valueToRoman.put(50, "L");
        valueToRoman.put(100, "C");
        valueToRoman.put(500, "D");
        valueToRoman.put(1000, "M");
        valueToRoman.put(4, "IV");
        valueToRoman.put(9, "IX");
        valueToRoman.put(40, "XL");
        valueToRoman.put(90, "XC");
        valueToRoman.put(400, "CD");
        valueToRoman.put(900, "CM");

    }

    private int[] baseValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();

        int baseIndex = 0;

        while (num > 0 && baseIndex < baseValues.length) {
            while (num >= baseValues[baseIndex]) {
                stringBuilder.append(valueToRoman.get(baseValues[baseIndex]));
                num -= baseValues[baseIndex];
            }
            baseIndex++;
        }

        return stringBuilder.toString();
    }
}
