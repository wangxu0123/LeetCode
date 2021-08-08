package Hot100;

import org.junit.Test;

import java.util.Arrays;

public class Hot518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        
        // for (int i = 1; i < amount + 1; i++){
        //     dp[i] = 1;
        // }
        dp[0] = 1;
        
        
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] = dp[i] + dp[i - coin];
                }
                
            }
        }
        
        return dp[amount];
    }
    
    @Test
    public void test() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
        
    }
}
