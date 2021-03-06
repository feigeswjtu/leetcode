package code455;

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
        int[] g = {1, 2, 3};
        int[] s = {3};
        int contentChildren = solution.findContentChildren(g, s);
        Assert.assertEquals(contentChildren, 1);
    }
}
