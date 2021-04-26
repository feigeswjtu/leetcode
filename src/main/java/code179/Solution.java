package code179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public String largestNumber(int[] nums) {
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, new LargestComparator());

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }


}

class LargestComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        int x = o1;
        int y = o2;
        long sx = 10, sy = 10;
        while (sx <= x) {
            sx *= 10;
        }
        while (sy <= y) {
            sy *= 10;
        }
        return (int) (-sy * x - y + sx * y + x);
    }
}

