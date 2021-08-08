package Hard;

import org.junit.Test;

import java.util.Arrays;

// 正则表达式匹配
public class Hard10 {
    public boolean isMatch(String s, String p) {
        char[] charArrayS = s.toCharArray();
        char[] charArrayP = p.toCharArray();
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // 初始化
        dp[0][0] = true;
        
        for (int j = 1; j <= n; j++) {
            if (j > 1) {
                if (charArrayP[j - 1] == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            } else {  // 表示P的第一个字符就是'*'
                if (charArrayP[j - 1] == '*') {
                    dp[0][j] = true;
                }
            }
        }
        
        // dp[i][j]表示 s的前i-1个字符 是不是能与 p的前j-1个 匹配的上
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (charArrayS[i - 1] == charArrayP[j - 1] || charArrayP[j - 1] == '.') {  // 1.表示S的第i-1个字符是不是与P的第j-1字符是不是相等的（注意p只要是.也可以认为相等）
                    dp[i][j] = dp[i - 1][j - 1];  // 如果相等，就取决于他俩前面的都能不能匹配上。
                } else if (charArrayP[j - 1] == '*') {  // 2.如果p的当前字符等于'*'，则有两种情况可以匹配上。
                    if (dp[i][j - 2] == true) {  // 2.1 表示，只要p的前j-2个字符可以匹配上，那它整个就可以匹配上。因为'*'可以把它前面的字符删掉。
                        dp[i][j] = true;
                    } else if ((charArrayS[i - 1] == charArrayP[j - 2] || charArrayP[j - 2] == '.') && dp[i - 1][j] == true) {  // 2.2 如果s的第i-1个等于j的j-1个等于的前提下，dp[i - 1][j]=true了，那也能匹配上
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        return dp[m][n];
    }
    
    
    @Test
    public void test() {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }
    
}
