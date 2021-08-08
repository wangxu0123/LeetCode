package Offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCFO56 {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 10, 4, 1, 4, 3, 3};
        System.out.println(Arrays.toString(singleNumbers(nums)));
        List<int[]> res = new ArrayList();
        
        //练习
//        res.add(new int[]{2, 3, 4});
//        res.add(new int[]{4, 5});
//        int[][] ints = res.toArray(new int[res.size()][]);
//        int[][] ints1 = res.toArray(new int[res.size()][]);
//        System.out.println(Arrays.toString(res.toArray(new int[res.size()][])));
        
    }
}
