package code26;

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
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int index = solution.removeDuplicates(nums);
        Assert.assertEquals(index, 5);
    }

    @Test
    public void test1() {
        int[] nums = {1, 1};
        int index = solution.removeDuplicates(nums);
        Assert.assertEquals(index, 1);
    }

    @Test
    public void test3() {
        int[] nums = {1, 1};
        int index = solution.removeDuplicates(nums);
        Assert.assertEquals(index, 1);
    }
    @Test
    public void test4() {
        int[] nums = {1, 2};
        int index = solution.removeDuplicates(nums);
        Assert.assertEquals(index, 2);
    }
}
