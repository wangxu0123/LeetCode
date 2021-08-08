package Offer;

import org.junit.Test;

import java.util.Arrays;

public class LCFO43 {
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
    
    
    @Test
    public void test() {
        int n = 13;
        System.out.println(countDigitOne(n));
        
    }
    
    
}

