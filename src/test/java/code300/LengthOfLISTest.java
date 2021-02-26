package code300;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: LengthOfLISTest.java, v 0.1 2021-02-26 09:12 feigeswjtu.cyf Exp $$
 */
public class LengthOfLISTest {
    @Test
    public void test() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution solution = new Solution();
        int length = solution.lengthOfLIS(nums);

        Assert.assertEquals(length, 4);

    }

    @Test
    public void test1() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        Solution solution = new Solution();
        int length = solution.lengthOfLIS(nums);

        Assert.assertEquals(length, 4);

    }


    @Test
    public void test2() {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        Solution solution = new Solution();
        int length = solution.lengthOfLIS(nums);

        Assert.assertEquals(length, 1);

    }
}
