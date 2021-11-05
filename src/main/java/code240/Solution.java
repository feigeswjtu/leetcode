package code240;

/**
 * 搜索二维矩阵 II
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int top = 0;
        int bottom = matrix.length - 1;


        while (top < bottom) {
            int mid = (bottom + top + 1) / 2;
            if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else if (matrix[mid][0] == target) {
                return true;
            } else {
                top = mid;
            }
        }
        if (top == 0 && matrix[0][0] > target) {
            return false;
        }

        while (top >= 0) {
            int left = 0;
            int right = matrix[0].length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[top][mid] > target) {
                    right = mid - 1;
                } else if (matrix[top][mid] == target) {
                    return true;
                } else {
                    left = mid + 1;
                }
            }
            top--;
        }

        return false;
    }

}
