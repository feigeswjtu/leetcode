package code8;

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
        int i = solution.myAtoi("42");
        Assert.assertEquals(i, 42);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int i = solution.myAtoi(" -42");
        Assert.assertEquals(i, -42);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int i = solution.myAtoi(
                "4193 with words");
        Assert.assertEquals(i, 4193);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int i = solution.myAtoi(
                "-91283472332");
        Assert.assertEquals(i,Integer.MIN_VALUE);
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        int i = solution.myAtoi(
                "  -0012a42");
        Assert.assertEquals(i,Integer.MIN_VALUE);
    }

    @Test
    public void test5() {
        Solution solution = new Solution();
        int i = solution.myAtoi(
                "-2147483649");
        Assert.assertEquals(i,Integer.MIN_VALUE);
    }

}
