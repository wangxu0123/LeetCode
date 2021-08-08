package Hot100;

import org.junit.Test;

public class Hot152 {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        
        int maxRes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(Math.max(nums[i], nums[i] * dpMax[i - 1]), nums[i] * dpMin[i - 1]);
            dpMin[i] = Math.min(Math.min(nums[i], nums[i] * dpMax[i - 1]), nums[i] * dpMin[i - 1]);
            maxRes = Math.max(maxRes, dpMax[i]);
        }
        
        return maxRes;
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{2, -5, -2, -4, 3};
        
        System.out.println(maxProduct(nums));
    }
}
