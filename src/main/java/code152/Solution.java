package code152;

/**
 * 乘积最大子数组
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int min = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0){
                int tmp = min;
                min = max;
                max = tmp;
            }

            max = Math.max(num, max * num);
            min = Math.min(num, min * num);

            result = Math.max(max, result);
        }

        return result;
    }
}
