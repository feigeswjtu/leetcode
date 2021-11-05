package code338;

/**
 * 比特位计数
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        int pre = 2;
        for (int i = 1; i <= n; i++) {
            if ((i & i - 1) == 0) {
                result[i] = 1;
                pre = i;
            } else {
                result[i] = result[i - pre] + 1;
            }
        }

        return result;
    }
}
