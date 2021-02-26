package code1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: TwoSumSolutionTest.java, v 0.1 2021-02-25 22:38 feigeswjtu.cyf Exp $$
 */
public class TwoSumSolutionTest {
    @Test
    public void testTwoSum(){
        Solution solution = new Solution();
        int[] nums = {2,7,11,15};
        int[] ints = solution.twoSum(nums, 9);
        Assert.assertEquals(ints[0], 0);
        Assert.assertEquals(ints[1], 1);

        ints = solution.twoSum(nums, 22);
        Assert.assertEquals(ints[0], 1);
        Assert.assertEquals(ints[1], 3);
    }

}
