package code7;

/**
 * 整数反转
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            if (res > 214748364 || (res == 214748364 && temp > 7)) {
                return 0;

            }
            if (res < -214748364 || (res == -214748364 && temp < -8)) {
                return 0;
            }

            res = res * 10 + temp;
            x = x/10;

        }
        return res;
    }
}
