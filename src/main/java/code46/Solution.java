package code46;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int length = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> result = new ArrayList<>();

        if (length == 0) {
            return result;
        }

        // 第几个数字是否已用
        boolean[] used = new boolean[length];
        List<Integer> path = new ArrayList<>();

        dfs(nums, length, 0, path, used, result);
        return result;
    }

    private void dfs(int[] nums, int length, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> result) {
        // 如果深度等于长度
        if (depth == length) {
            result.add(path);
            return;
        }

        // 每个都用一次
        for (int i = 0; i < length; i++) {
            // 如果当前值没有用，则用
            if (!used[i]) {
                // 1、每一次尝试都创建新的变量表示当前的"状态"
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);

                boolean[] newUsed = new boolean[length];
                System.arraycopy(used, 0, newUsed, 0, length);
                newUsed[i] = true;

                dfs(nums, length, depth + 1, newPath, newUsed, result);
            }
        }
    }
}

