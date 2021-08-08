package Hot100;

import org.junit.Test;

import java.util.Arrays;

public class Hot384 {
    int[] nums;
    
    public Hot384(int[] nums) {
        this.nums = nums;
    }
    
    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }
    
    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (nums.length == 0) {
            return null;
        }
        int[] res = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            double random = Math.random();
            int rand = (int) (random * (nums.length - i) + i);  // [i, nums.length)   注意i与rand都表示nums的索引
            swap(res, rand, i);
        }
        return res;
        
    }
    
    public void swap(int[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }
    
    
//    @Test
//    public void test() {
//        int[] nums = new int[]{1, 2, 3};
//
//        Hot384(nums)
//        System.out.println(Arrays.toString(exp.shuffle()));
//
//    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
    
        Hot384 exp = new Hot384(nums);
        System.out.println(Arrays.toString(exp.shuffle()));
    }
}
