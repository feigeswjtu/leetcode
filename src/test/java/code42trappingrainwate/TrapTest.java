package code42trappingrainwate;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: TrapTest.java, v 0.1 2021-02-26 00:02 feigeswjtu.cyf Exp $$
 */
public class TrapTest {
    @Test
    public void testTrap() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        Solution solution = new Solution();
        int trap = solution.trap(height);
        Assert.assertEquals(trap, 6);

    }

    @Test
    public void testTrap1() {
        int[] height = {4,2,0,3,2,5};


        Solution solution = new Solution();
        int trap = solution.trap(height);
        Assert.assertEquals(trap, 9);

    }
}

