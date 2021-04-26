package code897;

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
        node.val = 5;
        node.left = new TreeNode();
        node.left.val = 4;
        node.right = new TreeNode();
        node.right.val = 6;
        node.right.left = new TreeNode();
        node.right.left.val = 3;

        node.right.right = new TreeNode();
        node.right.right.val = 7;

        TreeNode treeNode = solution.increasingBST(node);
        Assert.assertNotNull(treeNode );

    }

}
