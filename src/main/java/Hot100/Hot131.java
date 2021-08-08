package Hot100;

import org.junit.Test;

import java.util.*;

public class Hot131 {
    String s;
    char[] charArray;
    List<List<String>> res = new ArrayList<>();
    List<String> path = new LinkedList<>();
    
    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 0) {
            return res;
        }
        this.s = s;
        this.charArray = s.toCharArray();
        dfs(0);
        return res;
    }
    
    private void dfs(int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            if (!checkPalindrome(startIndex, i)) {
                continue;
            }
            path.add(s.substring(startIndex, i + 1));
            dfs(i + 1);
            path.remove(path.size() - 1);
        }
    }
    
    private boolean checkPalindrome(int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    @Test
    public void test() {
        String s = "aab";
        
        System.out.println(partition(s));
    }
}
