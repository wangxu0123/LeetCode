package Offer;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

//剑指 Offer 17. 打印从1到最大的n位数
public class LCFO17 {
    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    public String printNumbers(int n) {
        // 初始化
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        
        // 开始递归执行
        dfs(0);
        
        // 消除最后一个字符，因为最后一个字符是逗号
        res.deleteCharAt(res.length() - 1);
        
        // 然后返回即可
        return res.toString();
    }
    
    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            
            if (!s.equals("0")) {
                res.append(s).append(",");
            }
            
            if (n - start == nine) {
                start--;
            }
            
            return;
        }
        for (char i : loop) {
            if (i == '9') {
                nine++;
            }
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
    
    
    @Test
    public void test() {
        
        System.out.println(printNumbers(3));
    }
    
}
