package Hot100;

import org.junit.Test;

public class Hot198 {
//    public int rob(int[] nums) {
//        int[] dp = new int[nums.length];
//
//        dp[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++){
//            dp[i] = Math.max(dp[i - 1], ((i - 2 >= 0) ? dp[i - 2] : 0) + nums[i]);
//        }
//
//        return dp[nums.length - 1];
//
//
//    }
    
    public int rob(int[] nums) {
        // 定义并初始化
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        // 开始动态规划
        for (int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = ((i - 2 >= 0) ? Math.max(dp[i - 2][0], dp[i - 2][1]) : 0) + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{2, 1, 1, 2};
        
        System.out.println(rob(nums));
    }
}
