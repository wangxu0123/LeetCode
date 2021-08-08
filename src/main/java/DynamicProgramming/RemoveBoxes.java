package DynamicProgramming;

import org.junit.Test;

//leetcode546题消消乐（移除盒子）
public class RemoveBoxes {
    int[][][] dp;
    
    public int removeBoxes(int[] boxes) {
        int length = boxes.length;
        dp = new int[length][length][length];
        return calculatePoints(boxes, 0, length - 1, 0);
    }
    
    public int calculatePoints(int[] boxes, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] == 0) {
            dp[l][r][k] = calculatePoints(boxes, l, r - 1, 0) + (k + 1) * (k + 1);
            for (int i = l; i < r; i++) {
                if (boxes[i] == boxes[r]) {
                    dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, l, i, k + 1) + calculatePoints(boxes, i + 1, r - 1, 0));
                }
            }
        }
        return dp[l][r][k];
    }
    
    @Test
    public void test() {
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        int res = removeBoxes(boxes);
        System.out.println(res);
    }
}
