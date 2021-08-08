package Offer;

import org.junit.Test;

import java.util.Arrays;

public class LCFO21 {
    public int[] exchange(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if ((nums[j] & 1) != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
            j++;
        }
        return nums;
    }
    
    @Test
    public void test() {
        
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }
}
