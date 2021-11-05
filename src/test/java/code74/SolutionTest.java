package code74;

import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test(){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        Solution solution = new Solution();
        boolean b = solution.searchMatrix(matrix, 13);
    }
}
