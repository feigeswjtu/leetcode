package code120;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 ){
            return 0;
        }
        int row = triangle.size();
        int col = triangle.get(0).size();
        int[][] distances = new int[triangle.size()][triangle.get(0).size()];

        for (int i = 0; i < row; i++) {

        }



        return 0;


    }
}

