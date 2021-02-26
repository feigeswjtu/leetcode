package code387;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: FirstUniqCharTest.java, v 0.1 2021-02-26 11:28 feigeswjtu.cyf Exp $$
 */
public class FirstUniqCharTest {
    @Test
    public void test() {
        String s = "leetcode";

        Solution solution = new Solution();
        int length = solution.firstUniqChar(s);

        Assert.assertEquals(length, 0);
    }
    @Test
    public void test1() {
        String s = "loveleetcode";

        Solution solution = new Solution();
        int length = solution.firstUniqChar(s);

        Assert.assertEquals(length, 2);
    }
    @Test
    public void test2() {
        String s = "leel";

        Solution solution = new Solution();
        int length = solution.firstUniqChar(s);

        Assert.assertEquals(length, -1);
    }

}
