package aother.q1277totalsquare;

/**
 * 统计全为1的正方形子矩阵个数
 *
 * @author feigeswjtu.cyf
 * @version $Id: DynamicProgrammingSolution.java, v 0.1 2021-02-05 16:22 feigeswjtu.cyf Exp $$
 */
public class DynamicProgrammingSolution implements Solution {
    /**
     * 总数
     *
     * @param matrix
     * @return
     */
    @Override
    public int totalSquare(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int dp[][] = new int[rows][cols];
        int totalCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                }

                if (dp[i][j] > 0) {
                    totalCount += dp[i][j];
                }

            }

        }

        return totalCount;
    }
}