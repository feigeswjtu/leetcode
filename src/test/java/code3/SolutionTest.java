package code3;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 01:00 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test(){
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(length, 3);

        length = solution.lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(length, 1);

        length = solution.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(length, 3);
    }
}
