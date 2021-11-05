package code121;

/**
 * 买卖股票的最佳时机
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
    public int maxProfitV3(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int dp0 = 0;// 不持有当前股票
        int dp1 = -prices[0]; // 持有当前股票

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, -price);
        }

        return dp0;
    }

    /**
     * 简单解法
     *
     * @param prices
     * @return
     */
    public int maxProfitV2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    /**
     * 双指针法
     * 
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxPrice = 0;
        int leftIndex = 0;
        int rightIndex = 1;

        // 右边索引小于价格长度
        while (rightIndex < prices.length) {
            // 如果右边的价格小于左边的价格，则移动索引
            if (prices[rightIndex] < prices[leftIndex]) {
                leftIndex = rightIndex;
                rightIndex = rightIndex + 1;
            } else {
                // 计算盈利
                int price = prices[rightIndex] - prices[leftIndex];
                maxPrice = Math.max(maxPrice, price);
                rightIndex++;
            }
        }

        return maxPrice;
    }
}
