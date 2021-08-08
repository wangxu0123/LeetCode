package Hot100;

import org.junit.Test;

import java.util.Arrays;

public class Hot55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len - 1];
    }
    
    
    @Test
    public void test() {
        int[] intervals = new int[]{2, 3, 1, 1, 4};
        
        canJump(intervals);
    }
}
