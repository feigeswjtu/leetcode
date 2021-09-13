package code128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 左区间计算法
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>(nums.length);
        // 所有结果放入hashSet中
        for (int num : nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;


        for (int num : hashSet) {
            // 从大于当前值的结果算起
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }


        return longestStreak;
    }

    /**
     * 动态规划算法
     *
     * @param nums
     * @return
     */
    public int longestConsecutiveV2(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.get(num - 1) == null ? 0 : map.get(num - 1);
                int right = map.get(num + 1) == null ? 0 : map.get(num + 1);
                int cur = 1 + left + right;
                if (cur > res) {
                    res = cur;
                }
                map.put(num, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);
            }
        }
        return res;
    }
}
