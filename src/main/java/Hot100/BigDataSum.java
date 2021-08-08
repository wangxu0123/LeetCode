package Hot100;

import org.junit.Test;

public class BigDataSum {
    public String solve(String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length() - 1;
        int j = t.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            stringBuilder.append(sum % 10);//添加到字符串尾部
            carry = sum / 10;
        }
        return stringBuilder.reverse().toString();//对字符串反转
    }
    
    
    @Test
    public void test() {
        System.out.println(solve("12367", "89"));
    }
}
