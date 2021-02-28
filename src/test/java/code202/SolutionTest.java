package code202;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test(){
        Solution solution = new Solution();
        boolean happy = solution.isHappy(19);
        Assert.assertTrue(happy);

        happy = solution.isHappy(2);
        Assert.assertFalse(happy);
    }


}
