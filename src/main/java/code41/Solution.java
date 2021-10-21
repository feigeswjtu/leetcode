package code41;

import java.util.HashSet;
import java.util.Set;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return length + 1;
    }
}
