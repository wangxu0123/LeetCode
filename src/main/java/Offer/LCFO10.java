package Offer;

import org.junit.Test;

/**
 *剑指 Offer 10- I. 斐波那契数列
 *
 * 动态规划 f(n + 1) = f(n) + f(n - 1)
 */
public class LCFO10 {
    
    
    public int fib(int n) {
        int res = 0;
        int left = 0;
        int right = 1;
        
        for (int i = 0; i < n; i++) {
            res = (left + right) % 1000000007;
            
            left = right;
            right = res;
            
        }
        
        return left;  // 返回倒数第二个值，因为倒数第二个位置 才是第n个位置
    }
    
    @Test
    public void test() {
        System.out.println(fib(5));
    }
}
