package code102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }


        Queue<LevelTreeNode> queue = new ArrayDeque<>();
        LevelTreeNode levelTreeNode = new LevelTreeNode(0, root);

        queue.add(levelTreeNode);

        while (!queue.isEmpty()) {
            LevelTreeNode levelTreeNodeTemp = queue.poll(); // Java 的 pop 写作 poll()
            List<Integer> data;
            if (result.size() > levelTreeNodeTemp.level) {
                data = result.get(levelTreeNodeTemp.level);
            }else {
                data = new ArrayList<>();
                result.add(levelTreeNodeTemp.level, data);
            }
            data.add(levelTreeNodeTemp.node.val);

            if (levelTreeNodeTemp.node.left != null) {
                queue.add(new LevelTreeNode(levelTreeNodeTemp.level + 1, levelTreeNodeTemp.node.left));
            }
            if (levelTreeNodeTemp.node.right != null) {
                queue.add(new LevelTreeNode(levelTreeNodeTemp.level + 1, levelTreeNodeTemp.node.right));
            }
        }
        return result;
    }

}

class LevelTreeNode {
    public LevelTreeNode(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }

    int level;
    TreeNode node;
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
