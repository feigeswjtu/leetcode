package code9;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public boolean isPalindrome(int x) {
        // 如果负数，并且最后一个字符为0时返回false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        // 位数处理
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
}
