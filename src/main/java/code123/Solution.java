package code123;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int dp0 = -prices[0];// 持有股票的最大价值
        int dp1 = 0; // 不持有股票，不是冷冻期
        int dp2 = 0; // // 不持有股票，冷冻期
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            int newDp0 = Math.max(dp0, dp1 - price);
            int newDp1 = dp2;
            int newDp2 = Math.max(dp0 + price, Math.max(dp1, dp2));

            dp0 = newDp0;
            dp1 = newDp1;
            dp2 = newDp2;
        }

        return Math.max(dp0, Math.max(dp1, dp2));
    }
    /**
     * int f0 = -prices[0]; 手上持有股票的最大收益 int f1 = 0; 手上不持有股票，并且处于冷冻期中的累计最大收益 int f2 = 0; 手上不持有股票，并且不在冷冻期中的累计最大收益
     *
     * int newf0 = max(f0, f2 - prices[i]); int newf1 = f0 + prices[i]; int newf2 = max(f1, f2);
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
