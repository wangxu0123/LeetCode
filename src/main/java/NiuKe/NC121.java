package NiuKe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NC121 {
    ArrayList<String> res = new ArrayList<>();
    List<Character> path = new ArrayList<>();
    
    //    StringBuilder path = new StringBuilder();
    public ArrayList<String> Permutation(String str) {
        dfs(str);
        return res;
    }
    
    public void dfs(String str) {
        if (path.size() == str.length()) {
            StringBuilder tempRes = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                tempRes.append(path.get(i));
            }
            res.add(tempRes.toString());
        }
        
        
        for (int i = 0; i < str.length(); i++) {
            if (path.contains(str.charAt(i))) {
                continue;
            }
            
            path.add(str.charAt(i));
            dfs(str);
            path.remove(path.size() - 1);
        }
        
        
    }
    
    @Test
    public void test() {
        String str = "ab";
        
        System.out.println(Permutation(str));
    }
}
