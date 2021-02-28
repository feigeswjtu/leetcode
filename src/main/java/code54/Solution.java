package code54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }


        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int totalCount = rowLength * colLength;

        List<Integer> result = new ArrayList<>(totalCount);
        if (matrix.length == 1){
            for (int value : matrix[0]) {
                result.add(value);
            }
            return result;
        }

        if (matrix[0].length == 1){
            for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        }

        int addCount = 0;

        int beginRow = 0;
        int beginCol = 0;
        int rowStep = rowLength;
        int colStep = colLength;
        while (addCount < totalCount) {
            for (int iStep = 0; iStep < colStep; iStep++) {
                result.add(matrix[beginRow][beginCol + iStep]);
                addCount++;
            }
            if (rowStep == 1){
                break;
            }

            for (int jStep = 1; jStep < rowStep; jStep++) {
                result.add(matrix[beginCol + jStep][beginCol + colStep - 1]);
                addCount++;
            }
            if (colStep == 1){
                break;
            }

            for (int iStep = colStep - 2; iStep >= 0; iStep--) {
                result.add(matrix[beginRow + rowStep - 1][beginCol + iStep]);
                addCount++;
            }
            for (int jStep = rowStep - 2; jStep > 0; jStep--) {
                result.add(matrix[beginRow + jStep][beginCol]);
                addCount++;
            }

            beginRow = beginRow + 1;
            beginCol = beginCol + 1;

            rowStep = rowStep - 2;
            colStep = colStep - 2;
        }
        return result;
    }
}
