package Hot100;

import org.junit.Test;

public class Hot329 {
    private int m, n;
    private int[][] matrix;
    private int[][] max;
    private int maxLen = 0;
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = m == 0 ? 0 : matrix[0].length;
        this.matrix = matrix;
        max = new int[m][n];
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (max[i][j] == 0)
                    longestIncreasingPath(i, j);
        return maxLen;
    }
    
    //返回以x, y 出发(包含)能拿到的最大路径数
    private int longestIncreasingPath(int x, int y) {
        if (max[x][y] != 0)
            return max[x][y];
        
        max[x][y] = 1;
        
        for (int k = 0; k < 4; k++) {
            int newX = x + dir[k][0];
            int newY = y + dir[k][1];
            if (isInRange(newX, newY) && matrix[x][y] < matrix[newX][newY])
                max[x][y] = Math.max(max[x][y], longestIncreasingPath(newX, newY) + 1);
            
        }
        
        maxLen = Math.max(maxLen, max[x][y]);
        return max[x][y];
    }
    
    private boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

//    public void dfs(int i, int j, int count, int lastValue) {
//        if (i < 0 || j < 0 || i >= m || j >= n || flag[i][j] == true || matrix[i][j] <= lastValue) {
//            res = Math.max(res, count);
//            return;
//        }
//
//
//        flag[i][j] = true;
//        dfs(i - 1, j, count + 1, matrix[i][j]);
//        dfs(i + 1, j, count + 1, matrix[i][j]);
//        dfs(i, j - 1, count + 1, matrix[i][j]);
//        dfs(i, j + 1, count + 1, matrix[i][j]);
//        flag[i][j] = false;
//
//    }
    
    @Test
    public void test() {
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        
        System.out.println(longestIncreasingPath(matrix));
    }
}
