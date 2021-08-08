package Hot100;

import org.junit.Test;

public class Hot474 {
//    public int findMaxForm(String[] strs, int m, int n) {
//        int len = strs.length;
//        int[][][] dp = new int[len + 1][m + 1][n + 1];
//
//        for (int i = 1; i <= len; i++){
//            int[] count = countZeroAndOne(strs[i - 1]);
//            for (int j = 0; j <= m; j++){
//                for (int k = 0; k <= n; k++){
//                    dp[i][j][k] = dp[i - 1][j][k];
//                    int zero_nums = count[0];
//                    int one_nums = count[1];
//                    if (j - zero_nums >= 0 && k - one_nums >= 0){
//                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zero_nums][k - one_nums] + 1);
//                    }
//
//                }
//            }
//        }
//        return dp[len][m][n];
//    }
    
    
    
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= len; i++){
            int[] count = countZeroAndOne(strs[i - 1]);
            for (int j = m; j >= 0; j--){
                for (int k = n; k >= 0; k--){
                    int zero_nums = count[0];
                    int one_nums = count[1];
                    if (j - zero_nums >= 0 && k - one_nums >= 0){
                        dp[j][k] = Math.max(dp[j][k], dp[j - zero_nums][k - one_nums] + 1);
                    }
                    
                }
            }
        }
        return dp[m][n];
    }
    
    public int[] countZeroAndOne(String str){
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }
    
    
    @Test
    public void test() {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));
    }
}


