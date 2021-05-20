package code993;

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
        TreeNode node = new TreeNode();
        node.val = 1;
        node.left = new TreeNode();
        node.left.val = 2;
        node.right = new TreeNode();
        node.right.val = 3;
        node.right.left = new TreeNode();
        node.right.left.val = 15;

        node.right.right = new TreeNode();
        node.right.right.val = 7;

        boolean is = solution.isCousins(node, 2, 3);

        Assert.assertFalse(is);
    }
}
