package Stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

// 42接雨水
public class TrappingRainWater {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
    
        for (int i = 0; i < height.length; i++){
        
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
            
                if (stack.isEmpty()){
                    break;
                }
            
                int left = stack.peek();
                int curWidth = i - left  - 1;
                int curHeight = Math.min(height[i], height[left]) - height[top];
            
                res = res + (curWidth * curHeight);
            }
        
            stack.push(i);
        }
        return res;
    }
    
    
    @Test
    public void test() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        System.out.println(trap(height));
    }
}
