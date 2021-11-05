package aother.knapsackproblem;

/**
 * 01背包问题
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-10-26 17:53 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可 计算01背包问题的结果
     * 
     * @param V
     *            int整型 背包的体积
     * @param n
     *            int整型 物品的个数
     * @param vw
     *            int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public int knapsack(int V, int n, int[][] vw) {
        int[][] dp = new int[n + 1][V + 1];
        for (int i = 1; i <= n; i++) { //
            for (int j = 1; j <= V; j++) {
                if (j < vw[i - 1][0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]);
                }
            }
        }
        return dp[n][V];
    }

    /**
     * 数组压缩之后
     *
     * @param V
     * @param n
     * @param vw
     * @return
     */
    public int knapsackV1(int V, int n, int[][] vw) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) { //
            for (int j = V; j >= vw[i - 1][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - vw[i - 1][0]] + vw[i - 1][1]);
            }
        }
        return dp[V];
    }
}
