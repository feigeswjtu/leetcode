package code91;

/**
 * 解码方法
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        if (s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int pre = 1, curr = 1;// dp[-1] = dp[0] = 1
        for (int i = 1; i < length; i++) {
            int tmp = curr;
            if (s.charAt(i) == '0')
                if (s.charAt(i-1) == '1' || s.charAt(i - 1) == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;

    }
}
