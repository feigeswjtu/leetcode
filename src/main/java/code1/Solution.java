package code1;

/**
 * 两数之和
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-25 22:29 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result  = new int[2];
        // 输入数组为null
        if (nums == null){
            return result;
        }

        // 输入数组长度为1
        if (nums.length == 1){
            return result;
        }


        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            for(int j = i + 1; j < nums.length; j++){
                // 找到和为目标结果
                if (nums[result[0]] + nums[j] == target) {
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;

    }
}
