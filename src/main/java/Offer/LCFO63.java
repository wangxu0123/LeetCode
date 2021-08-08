package Offer;

import org.junit.Test;

public class LCFO63 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for (int dayPrice : prices) {
            minPrice = Math.min(minPrice, dayPrice);
            res = Math.max(res, dayPrice - minPrice);
        }
        
        return res;
        
        // 以下是交易两次的
//        int res = 0;
//        int minPrice = Integer.MAX_VALUE;
//
//        for (int dayPrice : prices) {
//            minPrice = Math.min(minPrice, dayPrice);
//            res = Math.max(res, dayPrice - minPrice);
//        }
//        int firstPrice = minPrice;
//        minPrice = Integer.MAX_VALUE;
//        int res2 = 0;
//        for (int dayPrice : prices) {
//            if (dayPrice == firstPrice) {
//                continue;
//            }
//
//            minPrice = Math.min(minPrice, dayPrice);
//            res2 = Math.max(res2, dayPrice - minPrice);
//        }
//        return res + res2;
    }
    
    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
    
}
