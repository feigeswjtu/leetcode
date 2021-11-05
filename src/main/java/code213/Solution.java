package code213;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int rob0 = 0;
        int rob1 = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int num = nums[i];

            int tmp = rob0;
            // 不偷
            rob0 = Math.max(rob1, rob0); //
            rob1 = tmp + num;
        }
        int result = Math.max(rob0, rob1);

        rob0 = 0;
        rob1 = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];

            int tmp = rob0;
            // 不偷
            rob0 = Math.max(rob1, rob0); //
            rob1 = tmp + num;
        }

        result = Math.max(result, Math.max(rob0, rob1));
        return result;
    }
}
