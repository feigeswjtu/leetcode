package code213;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {2, 3, 2};
        int rob = solution.rob(nums);
        Assert.assertEquals(rob, 4);
    }
}
