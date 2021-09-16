package code102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 优化做法
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }

            result.add(list);
        }

        return result;
    }

    /**
     * 方法二 记录每个节点的位置
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        // 结果值
        List<List<Integer>> result = new ArrayList<>();
        // 如果root为null则直接返回
        if (root == null) {
            return result;
        }

        // 存放层序信息
        Queue<LevelTreeNode> queue = new ArrayDeque<>();
        // 层序信息
        LevelTreeNode levelTreeNode = new LevelTreeNode(0, root);

        queue.add(levelTreeNode);

        while (!queue.isEmpty()) {
            LevelTreeNode levelTreeNodeTemp = queue.poll(); // Java 的 pop 写作 poll()
            // 数据
            List<Integer> data;
            // 如果结果个数大于队列里的层序则取出来值
            if (result.size() > levelTreeNodeTemp.level) {
                data = result.get(levelTreeNodeTemp.level);
                // 否则新增一个值
            } else {
                data = new ArrayList<>();
                result.add(levelTreeNodeTemp.level, data);
            }
            // data里新增数据
            data.add(levelTreeNodeTemp.node.val);

            // 左节点入队列
            if (levelTreeNodeTemp.node.left != null) {
                queue.add(new LevelTreeNode(levelTreeNodeTemp.level + 1, levelTreeNodeTemp.node.left));
            }
            // 右节点入队列
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

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
