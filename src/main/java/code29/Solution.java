package code29;

/**
 * 两数相除
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        int count = 0;
        boolean isNegative = false;

        if (dividend > 0 && divisor < 0) {
            isNegative = true;
        }
        if (dividend < 0 && divisor > 0) {
            isNegative = true;
        }

        while (Math.abs(dividend) >= Math.abs(divisor)) {
            if (isNegative) {
                count--;
                dividend += divisor;
            } else {
                count++;
                dividend -= divisor;
            }
        }

        return count;
    }
}
