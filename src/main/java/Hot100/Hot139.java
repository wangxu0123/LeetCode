package Hot100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hot139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        Set<String> wordDictSet = new HashSet(wordDict);
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[j] && wordDictSet.contains(s.substring(j, i)));
                if (dp[i] == true) {
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    @Test
    public void test() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }
}
