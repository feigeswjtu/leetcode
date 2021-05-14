package code16;

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
        int[] nums = {-1, 2, 1, -4};
        int i = solution.threeSumClosest(nums, 1);
        Assert.assertEquals(i, 2);
    }

    @Test
    public void test1() {
        int[] nums = {-3, -2, -5, 3, -4};
        int i = solution.threeSumClosest(nums, -1);
        Assert.assertEquals(i, -2);
    }

    @Test
    public void test2() {
        int[] nums = {4, 0, 5, -5, 3, 3, 0, -4, -5};
        int i = solution.threeSumClosest(nums, -2);
        Assert.assertEquals(i, -2);
    }
}
