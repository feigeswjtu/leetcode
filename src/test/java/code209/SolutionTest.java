package code209;

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
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = solution.minSubArrayLen(7, nums);
        Assert.assertEquals(i, 2);
    }

    @Test
    public void test1() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int i = solution.minSubArrayLen(11, nums);
        Assert.assertEquals(i, 0);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4, 5};
        int i = solution.minSubArrayLen(11, nums);
        Assert.assertEquals(i, 3);
    }
}
