package code136;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int value = 0;
        for (int num : nums) {
            value = value ^ num;
        }
        return value;
    }
}
