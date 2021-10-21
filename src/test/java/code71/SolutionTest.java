package code71;

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
        String s = solution.simplifyPath("/a/./b/../../c/");
        Assert.assertEquals(s, "/c");
    }
    @Test
    public void test1(){
        Solution solution = new Solution();
        String s = solution.simplifyPath("/home/");
        Assert.assertEquals(s, "/home");
    }
    @Test
    public void test2(){
        Solution solution = new Solution();
        String s = solution.simplifyPath("/../");
        Assert.assertEquals(s, "/");
    }
    @Test
    public void test3(){
        Solution solution = new Solution();
        String s = solution.simplifyPath("/home//foo/");
        Assert.assertEquals(s, "/home/foo");
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        String s = solution.simplifyPath("/..hidden");
        Assert.assertEquals(s, "/..hidden");
    }



}
