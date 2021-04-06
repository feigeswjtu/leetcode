package code221;

/**
 * 最大正方形
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    private char ZERO = '0';
    private char ONE = '1';

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[][] matrixTemp = new int[matrix.length][matrix[0].length];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int mix = 0;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == ONE) {
                mix = 1;
                matrixTemp[i][0] = 1;
            }
        }

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == ONE) {
                mix = 1;
                matrixTemp[0][i] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == ONE) {
                    int min = matrixTemp[i][j - 1];
                    min = Math.min(min, matrixTemp[i - 1][j]);
                    min = Math.min(min, matrixTemp[i - 1][j - 1]);
                    matrixTemp[i][j] = min + 1;
                } else {
                    matrixTemp[i][j] = 0;
                }
                mix = Math.max(mix, matrixTemp[i][j]);
            }
        }


        return mix * mix;
    }
}
