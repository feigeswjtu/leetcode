package code342;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public boolean isPowerOfFour(int n) {
        boolean isPowerOfFour = (n & (n - 1)) == 0;

        if (!isPowerOfFour) {
            return false;
        }

        int length = 0;
        while (n > 0) {
            length++;
            n = (n >> 1);
        }
        if (length % 2 == 1) {
            return true;
        }

        return false;
    }
}
