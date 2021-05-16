package code8;

/**
 * 字符串转换整数 (atoi)
 *
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

            // 获取到空字符，忽略
            if (!hasReadValidChar && c == ' ') {
                continue;
            }

            // 获取到负号
            if (c == '-') {
                isNegativeNumber = true;
                hasReadValidChar = true;
                continue;
            }

            // 获取到正号
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

            // 如果是正数，并且超过了最大值，返回最大值
            if ((res > 214748364 || (res == 214748364 && temp > 7)) && !isNegativeNumber) {
                return Integer.MAX_VALUE;
            }

            // 如果是负数，并且超过了最小值，返回最小值
            if ((-res < -214748364 || (-res == -214748364 && temp > 8)) && isNegativeNumber) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + temp;
        }

        return isNegativeNumber ? -res : res;
    }
}
