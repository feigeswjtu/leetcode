package code1011;


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
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = solution.shipWithinDays(weights, 5);
        Assert.assertEquals(i, 11);
    }

}
