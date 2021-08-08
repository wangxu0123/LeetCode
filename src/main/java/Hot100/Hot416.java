package Hot100;

import org.junit.Test;

public class Hot416 {
    public boolean canPartition(int[] nums) {
        if (numsSum(nums) % 2 != 0) {
            return false;
        }
        
        // 定义所需变量
        int target = numsSum(nums) / 2;
        boolean[] dp = new boolean[target + 1];
        
        // 初始化第一行
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        
        // 开始动态规划（优化后的，优化过程可以看视频）
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (nums[i] <= j) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
                // 提前结束
                if (dp[target]) {
                    return true;
                }
            }
        }
        return dp[target];
    }
    
    // 数组求和函数
    private int numsSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
