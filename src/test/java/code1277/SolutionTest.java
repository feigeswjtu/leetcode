package code1277;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void test() {

        int[][] matrix = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};

        int countSquares = solution.countSquares(matrix);

        Assert.assertEquals(countSquares, 7);
    }
}
