package Offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LCFO62 {
//    public int lastRemaining(int n, int m) {
//        List<Integer> num = new ArrayList<>();
//        for (int i = 0; i < n; i++) num.add(i);
//        int temp = 0;
//        while (num.size() != 1) {
//            temp = (temp + m - 1);
//
//            if (temp >= num.size()) {
//                temp = temp % num.size();
//            }
//
//            num.remove(temp);
//        }
//        return num.get(0);
//    }
    
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
    
    @Test
    public void test() {
        
        System.out.println(lastRemaining(5, 3));
    }
}
