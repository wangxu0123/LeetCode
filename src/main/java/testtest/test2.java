package testtest;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.junit.Test;

public class test2 {//最长公共字串
    
    public int testtest2(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxRes = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                
                maxRes = Math.max(maxRes, dp[i][j]);
            }
        }
        return maxRes;
    }
    
    
    @Test
    public void test() {
        String str1 = "abcde";
        String str2 = "bcd";
        System.out.println(testtest2(str2, str1));
    }
}
