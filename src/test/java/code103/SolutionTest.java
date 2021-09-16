package code103;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
Solution solution = new Solution();
    @Test
    public void test(){
        TreeNode node = new TreeNode();
        node.val = 3;
        node.left = new TreeNode();
        node.left.val = 9;
        node.right = new TreeNode();
        node.right.val = 20;
        node.right.left = new TreeNode();
        node.right.left.val = 15;

        node.right.right= new TreeNode();
        node.right.right.val = 7;

        List<List<Integer>> lists = solution.zigzagLevelOrder(node);
        Assert.assertEquals(lists.size(), 3);
    }
}
