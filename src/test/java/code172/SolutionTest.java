package code172;

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
        for (int i = 0; i < 30; i++) {
            int value = i*10;
            System.out.println(solution.trailingZeroes1(value));
            System.out.println(solution.trailingZeroes(value));
            System.out.println("-----");

        }
    }
}
