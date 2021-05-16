package code22;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void test(){
        List<String> strings = solution.generateParenthesis(3);
        Assert.assertEquals(strings.size(), 5);
    }
}
