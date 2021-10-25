package code113;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        hasPathSum(result, new ArrayList<>(), root, targetSum);

        return result;

    }

    public void hasPathSum(List<List<Integer>> result, List<Integer> temp, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        temp.add(root.val);

        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            }
        }

        hasPathSum(result, temp, root.left, targetSum - root.val);
        hasPathSum(result, temp, root.right, targetSum - root.val);

        temp.remove(temp.size() - 1);

    }
}
