package Hot100;

import org.junit.Test;

public class Hot209 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;
        int sum = nums[left];
        
        while (left <= len - 1) {
            while (right <= len - 1 && sum < target) {
                sum = sum + nums[right];
                right++;
            }
            if (sum >= target) {
                res = Math.min(res, right - left);
            }
            sum = sum - nums[left];
            left++;
        }
        return res;
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
