package code5;

/**
 * 最长回文子串
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 动态规划实现
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        // [i][j] 代码i到j之间是否回文
        boolean[][] dp = new boolean[n][n];
        String result = "";
        // l是i和j的距离
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                // 距离为0时都是回文
                if (l == 0) {
                    dp[i][j] = true;
                    // 距离为1时
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                    // 大于1时通过动态规划解决
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > result.length()) {
                    result = s.substring(i, i + l + 1);
                }
            }
        }
        return result;
    }
}
