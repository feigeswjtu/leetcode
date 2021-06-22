package code1190;

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
        String s = solution.reverseParentheses("(abcd)");
        Assert.assertEquals(s, "dcba");
    }

    @Test
    public void test1() {
        String s = solution.reverseParentheses("(u(love)i)");
        Assert.assertEquals(s, "iloveu");
    }
}
