package code34;

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
        int[] nums = {5,7,7,8,8,10};
        int[]search = solution.searchRange(nums, 8);
        Assert.assertEquals(search[0], 3);
        Assert.assertEquals(search[1], 4);
    }

    @Test
    public void test1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] search = solution.searchRange(nums, 3);
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int[] search = solution.searchRange(nums, 1);
    }
}
