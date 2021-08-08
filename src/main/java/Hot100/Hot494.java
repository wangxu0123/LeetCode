package Hot100;

import org.junit.Test;

import java.util.Arrays;

public class Hot494 {
//    public int findTargetSumWays(int[] nums, int target) {
//        int sum = generateArraySum(nums);
//
//        if (sum < target || (target + sum) % 2 != 0) {
//            return 0;
//        }
//        Arrays.sort(nums);
//        int beibao = (target + sum) / 2;
//        int[] dp = new int[beibao + 1];
//
//        dp[0] = 1;
//
//        for (int num : nums) {
//            for (int j = beibao; j >= num; j--) {
//                dp[j] = dp[j] + dp[j - num];
//            }
//        }
//
//
//        return dp[beibao];
//    }
//
//    private int generateArraySum(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum = sum + num;
//        }
//
//        return sum;
//    }
    
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        Arrays.sort(nums);
        int newTarget = (target + sum) / 2;
        
        int[][] dp = new int[len + 1][newTarget + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= newTarget; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][newTarget];
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
    }
}
