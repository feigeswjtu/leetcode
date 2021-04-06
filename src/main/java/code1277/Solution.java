package code1277;

/**
 * 统计全为 1 的正方形子矩阵
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int totalCount = 0;
        int[][] matrixTemp = new int[matrix.length][matrix[0].length];
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 1) {
                totalCount++;
                matrixTemp[i][0] = 1;
            }
        }

        for (int i = 1; i < cols; i++) {
            if (matrix[0][i] == 1) {
                totalCount++;
                matrixTemp[0][i] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    int min = matrixTemp[i][j - 1];
                    min = Math.min(min, matrixTemp[i - 1][j]);
                    min = Math.min(min, matrixTemp[i - 1][j - 1]);
                    matrixTemp[i][j] = min + 1;
                    totalCount += matrixTemp[i][j];

                } else {
                    matrixTemp[i][j] = 0;
                }
            }
        }


        return totalCount;
    }

}
