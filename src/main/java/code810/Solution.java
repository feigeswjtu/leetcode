package code810;

/**
 * 黑板异或游戏
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public boolean xorGame(int[] nums) {
        // 如果length的长度为偶数，每次总能擦除一个数字使对方无法完成任务
        if (nums.length % 2 == 0) {
            return true;
        }

        int result = 0;

        // 否则最后如果异或结果为0，肯定获胜
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result == 0;
    }
}
