package code78;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 位运算解法
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        List<Integer> t = new ArrayList<>();

        // 位长度
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            // 低位开始算起，遇到1时入数组
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            result.add(new ArrayList<>(t));
        }
        return result;

    }

    /**
     * dfs解法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        result.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.length; i++) {
            dfs(result, temp, i, nums);
        }
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> temp, int index, int[] nums) {
        if (index == nums.length) {
            return;
        }

        temp.add(nums[index]);
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            dfs(result, temp, i + 1, nums);
        }
        temp.remove(temp.size() - 1);
    }
}
