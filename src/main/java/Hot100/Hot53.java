package Hot100;

import org.junit.Test;

public class Hot53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxRes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);  // 沿用 当前数组 还是 新开一个数组
            maxRes = Math.max(maxRes, dp[i]);
        }
        return maxRes;
    }
    
    
    @Test
    public void test() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        System.out.println(maxSubArray(nums));
    }
}
