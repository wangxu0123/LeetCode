package Hot100;

import org.junit.Test;

public class Hot75 {
    public void sortColors(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        int cur = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            }
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            while (nums[i] == 0) {
                swap(nums, left, i);
                left++;
            }
        }
    }
    
    public void swap(int nums[], int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    @Test
    public void test() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        
        sortColors(nums);
    }
}
