package code5;

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
        String s = solution.longestPalindrome("cbbd");
        Assert.assertEquals(s, "bb");
    }

    @Test
    public void test1() {
        String s = solution.longestPalindrome("ac");
        Assert.assertEquals(s, "a");
    }
    @Test
    public void test2() {
        String s = solution.longestPalindrome("bb");
        Assert.assertEquals(s, "bb");
    }
    @Test
    public void test3() {
        String s = solution.longestPalindrome("ccc");
        Assert.assertEquals(s, "ccc");
    }

    @Test
    public void test4() {
        String s = solution.longestPalindrome("aacabdkacaa");
        Assert.assertEquals(s, "aca");
    }
}
