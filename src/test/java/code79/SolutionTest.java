package code79;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test(){
        Solution solution = new Solution();
        char[][] board =

                {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean see = solution.exist(board, "ABCB");
        Assert.assertTrue(see);
    }


}
