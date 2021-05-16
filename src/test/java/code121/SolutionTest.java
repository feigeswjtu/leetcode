package code121;

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
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = solution.maxProfit(prices);
        Assert.assertEquals(i, 5);
    }


    @Test
    public void test1() {
        int[] prices = {2, 1, 2, 1, 0, 1, 2};
        int i = solution.maxProfit(prices);
        Assert.assertEquals(i, 2);
    }
}
