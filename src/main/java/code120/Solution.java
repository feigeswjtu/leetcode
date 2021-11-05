package code120;

import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] distances = new int[triangle.size()][triangle.get(row - 1).size()];

        distances[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    distances[i][j] = distances[i - 1][j] + triangle.get(i).get(j);
                } else {
                    if (j == i) {
                        distances[i][j] = distances[i - 1][j - 1] + triangle.get(i).get(j);
                    } else {

                        distances[i][j] =
                            Math.min(distances[i - 1][j - 1], distances[i - 1][j]) + triangle.get(i).get(j);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            min = Math.min(distances[row - 1][i], min);
        }

        return min;

    }
}
