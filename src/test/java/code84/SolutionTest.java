package code84;

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
        int[] height = {2,1,5,6,2,3};
        int i = solution.largestRectangleArea(height);
        Assert.assertEquals(i, 10);
    }
}
