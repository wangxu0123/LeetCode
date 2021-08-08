package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Dfs89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {  // 从最后一个开始往前反射
                res.add(head + res.get(j));  // 每个前面加上head，就是当前位置的结果
            }
            head <<= 1;
        }
        return res;
    }
    
    @Test
    public void test() {
        System.out.println(grayCode(3));
    }
    
}
