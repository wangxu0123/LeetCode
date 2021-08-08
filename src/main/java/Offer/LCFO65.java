package Offer;

import org.junit.Test;

public class LCFO65 {
    public int add(int a, int b) {
        int n = 0;
        int c = 0;
        // 因为s = a + b  = 进位c + 非进位和n
        // 且c = (a & b) << 1, n = a ^ b
        // 所以 s =   (a & b) << 1   +    a ^ b
        while (a != 0) {  // 这里不写c是因为 c一开始初始化的是0，写成c就没法进去循环了
            c = (a & b) << 1;
            n = a ^ b;
            
            a = c;
            b = n;
        }
        
        return n;  // 这里写b或者n都可以
    }
    
    
    @Test
    public void test() {
        
        System.out.println(add(2, 3));
    }
}
