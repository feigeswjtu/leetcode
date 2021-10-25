package code111;

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
        TreeNode node = new TreeNode();
        node.val = 3;
        node.left = new TreeNode();
        node.left.val = 9;

        node.left.left= new TreeNode();
        node.left.left.val = 7;

        node.left.left.left= new TreeNode();
        node.left.left.left.val = 10;
        int i = solution.minDepth(node);
        Assert.assertEquals(i, 6);
    }
}
