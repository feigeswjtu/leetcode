package code122;

/**
 * 买卖股票的最佳时机 II
 *
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

        int profit0 = 0;
        int profit1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            profit0 = Math.max(profit0, profit1 + price);
            profit1 = Math.max(profit1, profit0 - price);

        }

        return profit0;
    }
}
