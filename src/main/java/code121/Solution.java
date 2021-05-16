package code121;

/**
 * 买卖股票的最佳时机
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
//    public int maxProfit(int[] prices) {
//        if (prices.length <= 1) {
//            return 0;
//        }
//        int maxPrice = 0;
//        for (int leftIndex = 0; leftIndex < prices.length - 1; leftIndex++) {
//
//            for (int rightIndex = leftIndex; rightIndex < prices.length; rightIndex++) {
//                if (prices[rightIndex] > prices[leftIndex]) {
//                    maxPrice = Math.max(maxPrice, prices[rightIndex] - prices[leftIndex]);
//                }
//            }
//        }
//
//
//        return maxPrice;
//    }

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
