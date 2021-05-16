package code215;

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
        int[] nums = {3, 2, 1, 5, 6, 4};
        int kthLargest = solution.findKthLargest(nums, 2);
        Assert.assertEquals(kthLargest, 5);
    }
}
