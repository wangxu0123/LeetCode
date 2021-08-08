package Hot100;

import org.junit.Test;

public class Hot440 {
    
    public int findKthNumber(int n, int k) {
        long cur = 1;
        k = k - 1;
        
        while (k > 0) {
            int nodes = getNodes(n, cur);
            if (k >= nodes) {
                k = k - nodes;
                cur++;      //go right
            } else {
                k--;
                cur = cur * 10;  //go down
            }
        }
        
        return (int) cur;
    }
    
    private int getNodes(int n, long cur) {
        long next = cur + 1;
        long totalNodes = 0;
        
        while (cur <= n) {
            totalNodes += Math.min(n - cur + 1, next - cur);
            
            next *= 10;
            cur *= 10;
        }
        
        return (int) totalNodes;
    }
    
    @Test
    public void test() {
        int n = 109;
        int k = 5;
        System.out.println(findKthNumber(n, k));
    }
}


