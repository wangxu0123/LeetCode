package Hot100;

public class Hot79 {
    char[][] board;
    int m, n;
    String word;
    char[] words;
    boolean[][] flag;
    int[][] dir = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;
        this.words = word.toCharArray();
        this.flag = new boolean[m][n];
        
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                boolean res = dfs(i, j, 0);
                if (res == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, int k){
        if (!isInRange(i, j) || board[i][j] != words[k]){
            return false;
        }
        
        if (k == word.length()){
            return true;
        }
        
        
        boolean res = false;
        for (int d = 0; d < 4; d++){
            int newI = i + dir[d][0];
            int newJ = j + dir[d][1];
            
            flag[i][j] = true;
            res = dfs(newI, newJ, k + 1);
            if (res = true){
                break;
            }
            flag[i][j] = false;
        }
        
        return res;
    }
    
    public boolean isInRange(int i, int j){
        return (i >= 0 && j >= 0 && i <= m - 1 && j <= n - 1);
    }
}
