package Offer;

import org.junit.Test;

public class LCFO58 {
    
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {// 搜索首个空格
                i--;
            }
            
            res.append(s.substring(i + 1, j + 1)).append(" "); // 添加单词
            
            while (i >= 0 && s.charAt(i) == ' ') {// 跳过单词间空格
                i--;
            }
            
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串，并删除首位空格（这里其实只有最后有个空格），然后返回
    }
    
    @Test
    public void test() {
        String s = "  hello world!  ";
        System.out.println(reverseWords(s));
    }
}
