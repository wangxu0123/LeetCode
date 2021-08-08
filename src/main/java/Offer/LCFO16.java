package Offer;

import org.junit.Test;

public class LCFO16 {
    public double myPow(double x, int n) {
        
        if (x == 0) {
            return 0;
        }
        
        long b = n;
        
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            b = b >> 1;
        }
        return res;
        
    }
    
    
    @Test
    public void test() {
        
        System.out.println(myPow(2.0000, 4));
    }
}
