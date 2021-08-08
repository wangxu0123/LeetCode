package Hot100;

import org.junit.Test;

public class Hot96 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        
        for (int i = 2; i <= n; ++i) {  // 存下n之前所有的G，方便之后的计算使用，最后只用最后一个G[n]
            for (int j = 1; j <= i; ++j) {  // j循环一边所得到的G[i]：表示n=i的时候，所有可能性的总数
                G[i] = G[i] + G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
    
    @Test
    public void test() {
        int n = 3;
        
        System.out.println(numTrees(n));
    }
}
