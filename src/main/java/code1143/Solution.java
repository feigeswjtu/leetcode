package code1143;

/**
 * 最长公共子序列
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // 初始化动态化数组
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            // 取出c1的值
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                // 取出c2的值
                char c2 = text2.charAt(j - 1);
                // 如果c1=c2，当前最大公共子序列就是dp[i-1][j-1]
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // 否则是dp[i - 1][j], dp[i][j - 1]的最大值
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
