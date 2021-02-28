package code73;

/**
 * 矩阵置零
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int MODIFIED = -1000000;

        if (matrix.length == 0) {
            return;
        }
        if (matrix[0].length == 0) {
            return;
        }

        int rowsLength = matrix.length;

        int colsLength = matrix[0].length;

        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < colsLength; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < colsLength; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = MODIFIED;
                        }
                    }
                    for (int k = 0; k < rowsLength; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = MODIFIED;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < colsLength; j++) {
                if (matrix[i][j] == MODIFIED) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
