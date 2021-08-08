package Hot100;

import org.junit.Test;

public class Hot394 {
    public String decodeString(String s) {
        // 判断是不是全字母的字符串，也是递归终止条件
        if (onlyString(s)) {
            return s;
        }
        
        // 然后就开始得到第一个 [ 前的是什么
        int index = 0;
        int len = s.length();
        
        StringBuilder res = new StringBuilder();
        while (index < len) {  // 遍历每一个字符
            
            char ch = s.charAt(index);
            
            if ('a' <= ch && ch <= 'z') {
                res.append(ch);
                index++;
            } else {  // 走到这里说明是 数字、[、]三者其一
                int num = 0;
                int left = index;  // 指向第一个数字
                int right = index;
                while (right < len && s.charAt(right) >= '0' && s.charAt(right) <= '9') {  // 这里说明是数字
                    right++;
                }
                num = Integer.parseInt(s.substring(left, right));  // 现在num就得到了数字，并且right现在指向的一定是'['  (substring是左闭右开)
                
                left = right;
                right++;
                int leftP = 1;
                while (leftP != 0) {
                    char temp = s.charAt(right);
                    if (temp == ']') {
                        leftP--;
                    } else if (temp == '[') {
                        leftP++;
                    }
                    
                    if (leftP == 0) {  // 这是为了防止rigth再加导致越界
                        break;
                    }
                    right++;
                }
                
                // 现在就找到了子问题[]，left指向'[' ，right指向']'
                String smallFrac = decodeString(s.substring(left + 1, right));
                
                // 结合之前保存的num，遍历num次
                for (int i = 0; i < num; i++) {
                    res.append(smallFrac);
                }
                index = right + 1;  // 因为提前break导致right没有++，所以现在right指向的肯定是‘]’，所以index要指向‘]’的下一个值作为新的的开始
            }
        }
        return res.toString();
    }
    
    // 判断s是不是全字母的字符串
    private boolean onlyString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < 'a' || ch > 'z') {
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void test() {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
