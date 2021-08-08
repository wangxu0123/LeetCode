package Offer;

import org.junit.Test;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 例如：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class LCFO05 {
    public String replaceSpace(String s) {
        
        StringBuffer temp = new StringBuffer();
        
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                temp.append("%20");
            } else {
                temp.append(c);
            }
        }
        return temp.toString();
        
    }
    
    
    @Test
    public void test() {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
    
}
