package Hot100;

import org.junit.Test;

public class Hot200 {
    private int m, n;
    private char[][] grid;
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    res++;
                }
            }
        }
        return res;
        
        
    }
    
    public void dfs(int x, int y) {
        // 终止递归条件
        if (!isInRange(x, y) || grid[x][y] == '0') {
            return;
        }
        
        grid[x][y] = '0';
        for (int k = 0; k < 4; k++) {
            int newX = x + dir[k][0];
            int newY = y + dir[k][1];
            
            if (isInRange(newX, newY) && grid[newX][newY] == '1') {
                dfs(newX, newY);
            }
        }
        
        return;
    }
    
    private boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
    
    
    @Test
    public void test() {
        char[][] grid = {{'1'}, {'1'}};
        
        System.out.println(numIslands(grid));
    }
}
