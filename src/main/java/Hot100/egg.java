package Hot100;

import org.junit.Test;

public class egg {
    public int superEggDrop(int k, int n) {
        // k 鸡蛋数 n 为楼层数
        int[][] dp = new int[k + 1][n + 1];
        
        // 当楼层数为一时
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }
        
        // 当鸡蛋只有一颗时
        for (int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }
        
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                
                // 未使用二分的解法 x为所选楼层
                // int min = Integer.MAX_VALUE;
                // for(int x=1; x<=j; x++){
                //     min = Math.min(min, Math.max(dp[i-1][x-1], dp[i][j-x]));
                // }
                //dp[i][j] = 1 + min;
                
                // 改用二分查找
                int left = 1;
                int right = j;
                while (left + 1 < right) {
                    int mid = (left + right) / 2; // 在mid层扔鸡蛋
                    int down = dp[i - 1][mid - 1]; // 鸡蛋碎了 (单调递增)
                    int up = dp[i][j - mid]; // 鸡蛋没碎 （单调递减）
                    if (down > up) { // 单调递增的太大（往低处走）
                        right = mid;
                    } else if (down < up) { // 单调递减的太大 （往高处走）
                        left = mid;
                    } else { // 当down == up 代表找到了
                        left = right = mid;
                    }
                }
                //// 将范围缩小到 right - left <= 1
                int leftVal = Math.max(dp[i - 1][left - 1], dp[i][j - left]);
                int rightVal = Math.max(dp[i - 1][right - 1], dp[i][j - right]);
                dp[i][j] = 1 + Math.min(leftVal, rightVal);
            }
        }
        return dp[k][n];
    }
    
    
    @Test
    public void test() {
        System.out.println(superEggDrop(3, 14));
    }
}
