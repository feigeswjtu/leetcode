package code783;

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
        TreeNode treeNode = new TreeNode();
        treeNode.val = 90;
        treeNode.left = new TreeNode();
        treeNode.left.val = 69;

        treeNode.left.right = new TreeNode();
        treeNode.left.right.val = 89;
        treeNode.left.left = new TreeNode();
        treeNode.left.left.val = 49;

        treeNode.left.left.right = new TreeNode();
        treeNode.left.left.right.val = 52;
        int i = solution.minDiffInBST(treeNode);
        Assert.assertEquals(i, 1);
    }
}
