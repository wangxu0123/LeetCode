package Hard;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Hard85 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] grid = new int[row][col];
        int res = 0;
        buildRectangle(matrix, grid);//基于每一行都构造柱状图的函数，将grid构造好
        for (int i = 0; i < row; i++) {
            res = Math.max(res, curMaxRectangle(grid, i));
        }
        return res;
    }
    
    // 将grid构造好
    public void buildRectangle(char[][] matrix, int[][] grid) {
        int m = matrix.length;
        int n = matrix[0].length;
        //先构造第一行
        for (int j = 0; j < n; j++) {
            grid[0][j] = (matrix[0][j] == '1' ? 1 : 0);
        }
        //再构造往下的所有行
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = (matrix[i][j] == '1' ? grid[i - 1][j] + 1 : 0);
            }
        }
    }
    
    // 求以某index这一行为底的柱状图的最大结果
    public int curMaxRectangle(int[][] grid, int bottomIndex) {
        int[] arr = new int[grid[bottomIndex].length + 2];
        int len = arr.length;
        // 左右放入哨兵0之后的数组
        for (int i = 1; i <= grid[bottomIndex].length; i++) {
            arr[i] = grid[bottomIndex][i - 1];
        }
        
        int res = 0;//保存结果
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);// 第一个哨兵-1入栈
        int index = 1;//索引从范围[1, arr.length - 1]
        while (index < arr.length) {
            while (index < arr.length && arr[index] >= arr[stack.peekLast()]) {//单调递增的就入栈
                stack.addLast(index);
                index++;
            }
            
            while (index < arr.length && arr[index] < arr[stack.peekLast()]) {//碰到小于栈顶的就可以开始计算了
                int curHeight = arr[stack.removeLast()];
                res = Math.max(res, curHeight * (index - stack.peekLast() - 1));
            }
            
            stack.addLast(index);//都弄完，就把index加入栈
            index++;
        }
        return res;
    }
    
    @Test
    public void test() {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
