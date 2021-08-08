package Hard;

import org.junit.Test;

public class Hard123 {
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        int minVal = prices[0], maxVal = prices[prices.length - 1];
//        int[] dp = new int[prices.length];//从低到高，dp[i]表示第i天以及之前的区间所获得的最大利润
//        int[] dp2 = new int[prices.length];//从高到低，dp2[i]表示第i天开始直到最后一天期间所获得的最大利润
//        dp[0] = -prices[0];
//        for (int i = 1; i < prices.length; ++i) {
//            dp[i] = Math.max(dp[i - 1], prices[i] - minVal);
//            minVal = Math.min(prices[i], minVal);
//        }
//        for (int i = prices.length - 2; i >= 0; --i) {
//            dp2[i] = Math.max(dp2[i + 1], maxVal - prices[i]);
//            maxVal = Math.max(maxVal, prices[i]);
//        }
//        for (int i = 1; i <= prices.length - 1; ++i) {
//            // System.out.println(dp[i-1]+","+dp2[i]);
//            max = Math.max(dp[i - 1] + dp2[i], max);
//        }
//        return Math.max(dp[prices.length - 1], max);
//
//    }
    public int maxProfit(int[] prices) {//{7, 1, 5, 3, 5, 4}
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
    
    
    @Test
    public void test() {
        int[] nums = new int[]{7, 1, 5, 3, 5, 4};
        System.out.println(maxProfit(nums));
    }
}
