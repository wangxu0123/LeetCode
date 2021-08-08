package Hot100;

import org.junit.Test;

import java.util.Arrays;

public class Hot338 {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
    
    @Test
    public void test() {
        int num = 6;
        System.out.println(Arrays.toString(countBits(num)));
    }
}
