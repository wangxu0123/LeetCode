package Hot100;

import org.junit.Test;

public class Hot279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 初始化
        for(int i = 0; i <= n; i++){
            dp[i] = i;
        }
        
        // 开始动态规划
        for (int i = 1; i <= n; i++){
            for (int j = 2; j <= 10000; j++){
                if (i < j * j){
                    break;
                }
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
    
    @Test
    public void test() {
//        int[] coins = new int[]{1, 3, 4, 2, 2};
        System.out.println(numSquares(12));
    }
}
