package test333;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test33 {
    //餐馆 n张餐桌 容纳人数 a1 a2 --- an，
    // m组客人订年夜饭，
    // 每一组的人数：b1 b2 --- bm，   m
    // 消费金额    c1  c2 ---  cm，
    // 餐馆最大可能的营业额？
    
    //1张
    
    public int test33333(int a[], int[] b, int[] c, int n, int m) {
//        HashMap<Integer, Integer> mapA = new HashMap<>();
//        // 每桌餐桌人数
//        for (int i = 0; i < n; i++) {
//            mapA.put(a[i], mapA.getOrDefault(a[i], 0) + 1);
//        }
        
        //金额排序
        Arrays.sort(a);
        Arrays.sort(c);
        int res = 0;
//        for (int i = m - 1; i >= 0; i--) {
//            if (mapA.containsKey(b[i]) && mapA.get(b[i]) != 0) {
//                res += c[i];
//                mapA.getOrDefault(b[i], mapA.get(b[i]) - 1);
//            }
//        }
        boolean[] flag = new boolean[n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--){
                if (b[i] <= a[j] && flag[j] == false){
                    flag[j] = true;
                    res += c[i];
                    break;
                }
            }
        }
        return res;
    }
    
    @Test
    public void test() {
        int[] a = new int[]{3, 3, 3};
        int[] b = new int[]{3, 2, 4};
        int[] c = new int[]{5, 3, 6};
        System.out.println(test33333(a, b, c, a.length, b.length));
    }
}
