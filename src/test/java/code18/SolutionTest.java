package code18;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test() {
        int[] nums = {1, 0, -1, 0, -2, 2};


        List<List<Integer>> lists = solution.fourSum(nums, 0);
        Assert.assertEquals(lists.size(), 3);
    }

    @Test
    public void test1() {
        int[] nums = {2, 2, 2, 2, 2};

        List<List<Integer>> lists = solution.fourSum(nums, 8);
        Assert.assertEquals(lists.size(), 1);
    }
}
