package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hot438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] charArrayS = s.toCharArray();
        char[] charArrayP = p.toCharArray();
        int[] need = new int[128];  // 定义need数组，存p
        int[] window = new int[128];  // 定义window数组，存滑动窗口内的值
        
        // 初始化need数组
        for (Character c : p.toCharArray()) {
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
        // 开始将s一个一个进行判断
        for (int i = 0, j = 0; i < s.length(); i++) {
            // 1.动指针i，添加一个字符到窗口中，并更新一些列数据：
            window[charArrayS[i]]++;
            if (window[charArrayS[i]] == need[charArrayS[i]]) {
                match++;
            }
            
            // 2.窗口左缩小的时机（窗口长度等于p的长度时）
            while (i - j + 1 == charArrayP.length) {
                // 窗口长度满足了，要左缩前，要先修改一系列数据，修改完成后再左缩。
                
                // 3.更新答案：看看内容是不是匹配了，符合要求就加入结果List中
                if (match == need_size) {
                    res.add(j);
                }
                
                // 4.缩小前的先更新数据
                if (window[charArrayS[j]] == need[charArrayS[j]]) {
                    match--;
                }
                window[charArrayS[j]]--;
                
                // 状态更新完成，可以左缩j了。
                j++;
            }
        }
        return res;
    }
    
    @Test
    public void test() {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
