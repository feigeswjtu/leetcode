package code137;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字 II
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int singleNumber1(int[] nums) {
        int value = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3);
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                value = value ^ num;
                continue;
            }

            if (map.get(num) == 1) {
                value = value ^ num;
                map.put(num, 2);
            }

        }

        return value;
    }


    public int singleNumber(int[] nums) {
        int value0 = 0;
        int value1 = 0;
        for (int num : nums) {
            value0 = value0 ^ num & ~value1;
            value1 = value1 ^ num & ~value0;
        }



        return value0;
    }

}
