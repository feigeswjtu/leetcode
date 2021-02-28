package code6;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test(){
        String s = "PAYPALISHIRING";
        Solution solution = new Solution();
        String convert = solution.convert(s, 3);
        Assert.assertEquals(convert, "PAHNAPLSIIGYIR");
    }

    @Test
    public void test1(){
        String s = "A";
        Solution solution = new Solution();
        String convert = solution.convert(s, 1);
        Assert.assertEquals(convert, "PAHNAPLSIIGYIR");
    }
}
