package Hot100;

import org.junit.Test;

public class Hot76 {
    public String minWindow(String s, String t) {
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        int[] need = new int[128];  // 定义need数组，存p
        int[] window = new int[128];  // 定义window数组，存滑动窗口内的值
        
        int begin = 0;
        int minLen = s.length() + 1;
        
        // 初始化need数组
        for (char c : charArrayT) {
            need[c]++;
        }
        
        // 得到不重复的字母数量(后面与match做长度匹配用)
        int need_size = 0;
        for (int k : need) {
            if (k != 0) {
                need_size++;
            }
        }
        
        int match = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            window[charArrayS[i]]++;
            
            if (window[charArrayS[i]] == need[charArrayS[i]]) {
                match++;
            }
            
            while (match == need_size) {
                if (minLen > i - j + 1) {
                    minLen = Math.min(minLen, i - j + 1);
                    begin = j;
                }
                
                if (window[charArrayS[j]] == need[charArrayS[j]]) {
                    match--;
                }
                
                window[charArrayS[j]]--;
                j++;
            }
        }
        
        if (minLen == s.length() + 1) {
            return "";
        } else {
            return s.substring(begin, begin + minLen);
        }
        
    }
    
    @Test
    public void test() {
//        String s = "cabwefgewcwaefgcf";
        String s = "ADOBECODEBANC";
//        String t = "cae";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
