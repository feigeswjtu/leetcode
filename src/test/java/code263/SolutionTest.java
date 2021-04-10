package code263;

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
        boolean ugly = solution.isUgly(6);
        Assert.assertTrue(ugly);
    }


    @Test
    public void test1() {
        boolean ugly = solution.isUgly(-2147483648);
        Assert.assertTrue(ugly);
    }
}
