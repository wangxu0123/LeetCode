package Hot100;

import org.junit.Test;

public class Hot647 {
    public int countSubstrings(String s) {
        // s = "aaababa"
        int n = s.length();
        int res = 0;  // 结果数量
        
        // 以单数为中心，例如”a“
        for (int i = 0; i < n; i++) {
            res = res + speard(s, i, i);
        }
        
        // 以双数为中心，例如”aa“
        for (int i = 0; i < n - 1; i++) {
            res = res + speard(s, i, i + 1);
        }
        
        return res;
    }
    
    // 编写 扩散 函数
    public int speard(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r <= (s.length() - 1) && s.charAt(l) == s.charAt(r)) {
            count++;  // 进来了说明可以扩散后满足回文，那么count++
            
            // 然后l左移，r右移，进行扩散，再去看扩散后是不是满足回文
            l--;
            r++;
        }
        return count;
    }
    
    @Test
    public void test() {
        String s = "aaababa";
        
        System.out.println(countSubstrings(s));
    }
}
