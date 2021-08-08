package Hot100;

import org.junit.Test;

import java.util.Arrays;

public class Hot322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (coins[j] <= i) {
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
//        return dp[amount] >= (amount + 1) ? -1 : dp[amount];
    
        for (int coin : coins){
            for (int i = 1; i <= amount; i++){
                if (i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
    
        return dp[amount];
    }
    
    @Test
    public void test() {
        int[] coins = new int[]{2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }
}
