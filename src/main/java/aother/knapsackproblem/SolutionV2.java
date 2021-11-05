package aother.knapsackproblem;

/**
 * 完全背包问题
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-10-26 17:53 feigeswjtu.cyf Exp $$
 */
public class SolutionV2 {
    /**
     * 数组压缩之后
     *
     * @param V
     *
     * @param n
     * @param vw
     * @return
     */
    public int knapsackV1(int V, int n, int[][] vw) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) { //
            for (int j = vw[i - 1][0]; j <=V; j++) {
                //for (int j = V; j >= vw[i - 1][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - vw[i - 1][0]] + vw[i - 1][1]);
            }
        }
        return dp[V];
    }
}
