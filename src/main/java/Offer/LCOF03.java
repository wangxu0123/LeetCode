package Offer;

import org.junit.Test;

import javax.swing.plaf.IconUIResource;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */


public class LCOF03 {
    
    public int findRepeatNumber(int[] nums) {
        int temp = 0;
        int i = 0;
        while (i < nums.length) {
    
            if (nums[i] == i){
                i++;
                continue;
            }
            
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            } else {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            
            
        }
        return 0;
    }
    
    
    @Test
    public void test() {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));
    }
}
