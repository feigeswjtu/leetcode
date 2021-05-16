package code62;

/**
 * 不同路径
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        // 到达m,n的路径个数
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            // 横坐标为0的所有路径为1
            matrix[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            // 纵坐标为0的所有路径为1
            matrix[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 动态规划转移
                matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
            }
        }


        return matrix[m - 1][n - 1];
    }
}
