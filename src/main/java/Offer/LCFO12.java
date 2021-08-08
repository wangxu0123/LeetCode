package Offer;

import org.junit.Test;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class LCFO12 {
//    public boolean exist(char[][] board, String word) {
//
//        char[] words = word.toCharArray();
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//
//                if (dfs(board, words, i, j, 0) == true) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//
//    public boolean dfs(char[][] board, char[] words, int i, int j, int k) {
//        // 以下情况直接返回false，
//        // 1：board[i][j] == words[k]
//        // 2：四边越界：i > board.length - 1     j > board[0].length-1    i < 0   j < 0
//        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != words[k]) {
//            return false;
//        }
//
//        // 走到这里说明目前的 board[i][j] == words[k]是匹配的，先判断一下这个k是不是最后一个了，如果是的话就可以向前层返回true了（然后就会层层返回true，最后结果表示找到了word）。
//        if (k == words.length - 1) {
//            return true;
//        }
//        // 所以需要把board[i][j]给变成空
//        board[i][j] = '\0';
//
//        // 然后继续向下走，如果不满足要求就向上（右，左），如果四个方向都不满足，res就自动等于false了，如果有一个满足res就等于true
//        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1);
//
//        // 走到这里说明当前words中k位置时，四个方向都走完了，res已经有结果了，需要向前层返回了结果了，所以要把board[i][j]标志位给还原回去
//        board[i][j] = words[k];
//
//        return res;
//    }

//    char[][] board;
//    String word;
//    char[] words;
//    boolean[][] flag;
//    int m;
//    int n;
//
//    public boolean exist(char[][] board, String word) {
//        this.board = board;
//        this.word = word;
//        this.words = word.toCharArray();
//        this.m = board.length;
//        this.n = board[0].length;
//        this.flag = new boolean[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                boolean res = searchRes(i, j, 0);
//                if (res == true) {
//                    return res;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    public boolean searchRes(int i, int j, int k) {
//        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || flag[i][j] == true || board[i][j] != words[k]) {
//            return false;
//        }
//
//        if (k == word.length() - 1) {
//            return true;
//        }
//
//
//        flag[i][j] = true;
//
//        boolean res = searchRes(i - 1, j, k + 1) || searchRes(i, j - 1, k + 1) || searchRes(i + 1, j, k + 1) || searchRes(i, j + 1, k + 1);
//
//        flag[i][j] = false;
//
//        return res;
//    }
    
    char[][] board;
    int m, n;
    String word;
    char[] words;
    boolean[][] flag;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;
        this.words = word.toCharArray();
        this.flag = new boolean[m][n];
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = dfs(i, j, 0);
                if (res == true) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, int k) {
        if (!isInRange(i, j) || board[i][j] != words[k] || flag[i][j] == true) {
            return false;
        }
        
        if (k == word.length() - 1) {
            return true;
        }
        
        
        boolean res = false;
        for (int d = 0; d < 4; d++) {
            int newI = i + dir[d][0];
            int newJ = j + dir[d][1];
            
            flag[i][j] = true;
            
            res = dfs(newI, newJ, k + 1);
            if (res == true) {
                break;
            }
            
            flag[i][j] = false;
        }
        
        return res;
    }
    
    public boolean isInRange(int i, int j) {
        return (i >= 0 && j >= 0 && i <= m - 1 && j <= n - 1);
    }
    
    
    @Test
    public void test() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = {{'a'}};
        
        String word = "ABCB";
        
        System.out.println(exist(board, word));
    }
}
