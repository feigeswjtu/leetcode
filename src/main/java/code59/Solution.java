package code59;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 0;
        int totalCount = n * n;
        int[][] matrix = new int[n][n];

        while (num < totalCount) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                matrix[top][i] = ++num;
            }
            top++;

            // 从上到下
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = ++num;
            }
            right--;

            // 从右到左
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = ++num;
            }
            bottom--;

            // 从下到上
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = ++num;
            }
            left++;
        }

        return matrix;
    }
}
