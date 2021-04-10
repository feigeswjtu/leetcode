package code263;

/**
 * 丑数
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public boolean isUgly(int n) {
        if (n <=0){
            return false;
        }
        boolean isUgly = true;
        while (isUgly && n > 1) {
            if (n % 3 == 0) {
                n = n / 3;
                continue;
            }

            if (n % 5 == 0) {
                n = n / 5;
                continue;
            }

            if (n % 2 == 0) {
                n = n / 2;
                continue;
            }
            isUgly = false;
        }

        return isUgly;

    }

}
