package Offer;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LCFO13 {
    public int movingCount(int m, int n, int k) {
        int[][] nums = new int[m][n];
        return dfs(nums, 0, 0, k);
    }
    
    public int dfs(int[][] nums, int i, int j, int k) {
        
        int count = 0;
        
        // 注意要先判断i > nums.length - 1 || j > nums[0].length - 1
        if (i > nums.length - 1 || j > nums[0].length - 1 || getSum(i) + getSum(j) > k || nums[i][j] == 1) {
            return 0;
        }
        
        nums[i][j] = 1;
        
        count = 1 + dfs(nums, i + 1, j, k) + dfs(nums, i, j + 1, k);
        
        return count;
        
    }


//    public int splitSum(int i, int j) {
//
//        char[] si = String.valueOf(i).toCharArray();
//        char[] sj = String.valueOf(j).toCharArray();
//        i = 0;
//        j = 0;
//        for (char ci : si) {
//            i = i + ci - '0';
//        }
//        for (char cj : sj) {
//            j = j + cj - '0';
//        }
//
//        return i + j;
//    }
    
    public int getSum(int i) {
        int sum = i % 10;
        int temp = i / 10;
        
        while (temp > 0) {
            sum = sum + temp % 10;
            temp = temp / 10;
        }
        
        return sum;
    }
    
    @Test
    public void test() {

//        System.out.println(splitSum(16, 8));
        
        
        System.out.println(movingCount(16, 8, 4));
    }
}
