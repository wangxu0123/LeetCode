package Offer;

import org.junit.Test;

public class LCFO14 {
    
    public int cuttingRope(int n) {
        
        if (n <= 3) {
            return n - 1;
        }
        
        n = n % 1000000007;
        int a = n / 3;
        int b = n % 3;
        
        if (b == 0) {
            return (int) (Math.pow(3, a)) % 1000000007;
        } else if (b == 1) {
            return (int) (Math.pow(3, a - 1)) * 4 % 1000000007;
        } else {
            return (int) (Math.pow(3, a) * 2) % 1000000007;
        }
        
    }
    
    
    @Test
    public void test(){
        System.out.println(cuttingRope(120));
    }
    
}

