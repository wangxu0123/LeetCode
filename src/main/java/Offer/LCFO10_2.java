package Offer;

import org.junit.Test;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 动态规划 f(n + 1) = f(n) + f(n - 1)
 */


public class LCFO10_2 {
    
    public int numWays(int n) {
        
        int left = 1;  // n=0的时候取1
        int right = 1;  // n=1的时候取1
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum = (left + right) % 1000000007;
            left = right;
            right = sum;
            
            
        }
        return left;  // 返回倒数第二个值，因为倒数第二个位置 才是第n个位置（返回left是因为每次进行相加之后，left和right都向右移动了一位。所以此时left才是要返回的位置）
    }
    
    @Test
    public void test() {
        
        int n = 7;
        
        System.out.println(numWays(n));
        
        
    }
    
}
