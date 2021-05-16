package code10;

/**
 * 正则表达式匹配
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        // 处理原始数据
        s = " " + s;
        p = " " + p;
        int sLength = s.length();
        int pLength = p.length();

        // s的前i个字符与p中的前j个字符是否能够匹配
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        // 第一个字符肯定可以
        dp[0][0] = true;
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                    }
                }

            }

        }

        return dp[sLength][pLength];
    }
}
