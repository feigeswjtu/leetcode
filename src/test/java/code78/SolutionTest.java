package code78;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = solution.subsets1(nums);
        Assert.assertEquals(lists.size(), 9);
    }
}
