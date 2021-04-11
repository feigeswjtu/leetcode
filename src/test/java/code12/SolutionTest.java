package code12;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 整数转罗马数字
 *
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void test(){
        String s = solution.intToRoman(3);
        Assert.assertEquals(s, "III");
    }
    @Test
    public void test1(){
        String s = solution.intToRoman(4);
        Assert.assertEquals(s, "IV");
    }
    @Test
    public void test2(){
        String s = solution.intToRoman(9);
        Assert.assertEquals(s, "IX");
    }
    @Test
    public void test58(){
        String s = solution.intToRoman(58);
        Assert.assertEquals(s, "LVIII");
    }
    @Test
    public void test1994(){
        String s = solution.intToRoman(1994);
        Assert.assertEquals(s, "MCMXCIV");
    }
}
