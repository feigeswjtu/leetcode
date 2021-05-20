package code70;

/**
 * 爬楼梯
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int climbStairs(int stairHeight) {
        // 楼梯高度为0时
        if (stairHeight == 0) {
            return 0;
        }

        // 楼梯高度为1时
        if (stairHeight == 1) {
            return 1;
        }

        // 楼梯高度为2时
        if (stairHeight == 2) {
            return 2;
        }

        int beforeOneStepCount = 1;
        int beforeTwoStepCount = 2;

        int currentStepCount = 0;

        for (int step = 3; step <= stairHeight; step++) {
            currentStepCount = beforeOneStepCount + beforeTwoStepCount;
            beforeOneStepCount = beforeTwoStepCount;
            beforeTwoStepCount = currentStepCount;
        }
        return currentStepCount;
    }
}
