package code9;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void test(){
        boolean palindrome = solution.isPalindrome(1230000321);
        Assert.assertTrue(palindrome);
    }
}
