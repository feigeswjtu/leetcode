package code15;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test(){

        int[] nums = {-1,0,1,2,-1,-4};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        Assert.assertEquals(lists.size(), 2);
    }
}
