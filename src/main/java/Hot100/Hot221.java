package Hot100;

import org.junit.Test;

public class Hot221 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        
        int maxRes = 1;
//        for (int i = matrix.length; i >= 1; i--) {
//            for (int j = matrix[0].length; j >= 1; j--) {
//                if (matrix[i - 1][j - 1] == '1') {
//                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
//                    maxRes = Math.max(dp[i][j], maxRes);
//                }
//            }
//        }
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxRes = Math.max(dp[i][j], maxRes);
                }
            }
        }
        return maxRes * 2;
    }
    
    @Test
    public void test() {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'0', '1'}, {'1', '0'}};
        
        System.out.println(maximalSquare(matrix));
    }
}
