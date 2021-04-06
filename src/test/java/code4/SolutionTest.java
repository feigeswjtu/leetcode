package code4;

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
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(medianSortedArrays, 2.0D);

    }

    @Test
    public void test1() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(medianSortedArrays, 2.5D);

    }
}
