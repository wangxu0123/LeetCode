package Offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
public class LCOF56_1 {
    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> result = new ArrayList<>();
        int[] res = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            
            if (result.size() == 2) {
                for (int j = 0; j < 2; j++) {
                    res[j] = result.get(j);
                }
                return res;
            }
            
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    result.add(nums[i]);
                    if (nums[i + 1] != nums[i + 2]) {
                        result.add(nums[i + 1]);
                        for (int j = 0; j < 2; j++) {
                            res[j] = result.get(j);
                        }
                        return res;
                    }
                }
            } else if (i == len - 3) {
                if (nums[len - 3] != nums[len - 2]) {
                    if (nums[len - 2] != nums[len - 1]) {
                        res[0] = nums[len - 2];
                        res[1] = nums[len - 1];
                        return res;
                    }
                }
            } else if (i == len - 2) {
                if (nums[len - 2] != nums[len - 1]) {
                    result.add(nums[len - 1]);
                    for (int j = 0; j < 2; j++) {
                        res[j] = result.get(j);
                    }
                    return res;
                }
            } else if (nums[i] != nums[i + 1]) {
                if (nums[i + 1] != nums[i + 2]) {
                    if (i <= (len - 4) && nums[i + 2] != nums[i + 3]) {
                        res[0] = nums[i + 1];
                        res[1] = nums[i + 2];
                        return res;
                    }
                    result.add(nums[i + 1]);
                }
                
            }
            
            
        }
        return res;
    }
    
    @Test
    public void test() {
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        int[] a = singleNumbers(nums);
        for (int num : a) {
            System.out.println(num);
        }
    }
}

