package code8;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int myAtoi(String s) {
        int res = 0;
        boolean isNegativeNumber = false;
        boolean hasReadValidChar = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 获取到无效字符
            if (hasReadValidChar && (c < '0' || c > '9')) {
                return isNegativeNumber ? -res : res;
            }

            if (!hasReadValidChar && c == ' ') {
                continue;
            }

            if (c == '-') {
                isNegativeNumber = true;
                hasReadValidChar = true;
                continue;
            }

            if (c == '+') {
                hasReadValidChar = true;
                continue;
            }
            hasReadValidChar = true;

            // 获取到无效字符
            if (hasReadValidChar && (c < '0' || c > '9')) {
                return isNegativeNumber ? -res : res;
            }

            int temp = c - '0';

            if ((res > 214748364 || (res == 214748364 && temp > 7)) && !isNegativeNumber) {
                return Integer.MAX_VALUE;
            }

            if ((-res < -214748364 || (-res == -214748364 && temp > 8)) && isNegativeNumber) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + temp;
        }

        return isNegativeNumber ? -res : res;
    }
}
