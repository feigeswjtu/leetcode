package code169;

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
        int[] nums = {3, 2, 3};
        int num = solution.majorityElement(nums);
        Assert.assertEquals(num, 3);

        nums = new int[] {2,2,1,1,1,2,2};
        num = solution.majorityElement(nums);
        Assert.assertEquals(num, 2);

        nums = new int[] {10,9,9,9,10};
        num = solution.majorityElement(nums);
        Assert.assertEquals(num, 9);

    }
}
