package Offer;

import org.junit.Test;

import java.util.Arrays;

public class LCOF56 {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            } else if (i == len - 2) {
                if (nums[len - 2] != nums[len - 1]) {
                    return nums[len - 1];
                }
            } else if (nums[i] != nums[i + 1]) {
                if (nums[i + 1] != nums[i + 2]) {
                    return nums[i + 1];
                }
            }
        }
        return 0;
    }
    
    
    @Test
    public void test() {
        int[] nums = {4, 10, 4, 10, 2, 4, 10};
        int a = singleNumber(nums);
        System.out.println(a);
    }
}
