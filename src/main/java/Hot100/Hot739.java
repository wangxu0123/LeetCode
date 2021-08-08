package Hot100;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 每日温度
public class Hot739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> indexStack = new LinkedList<>();  // 维护一个单调栈
        
        int[] res = new int[temperatures.length];  // 保存结果
        
        for (int i = 0; i < temperatures.length; i++) {
            
            // 如果来的这个新值temperatures[i]，它是大于栈顶的，那就删除栈顶，然后记录以下i - index存入res对应位置（因为它就是现在栈顶这个位置的最短升温天数）（所以注意res的值不是按从左到右顺序得到的）
            while (!indexStack.isEmpty() && temperatures[indexStack.peekLast()] < temperatures[i]) {
                int index = indexStack.removeLast();
                res[index] = i - index;
            }
            
            // 到这里说明现在 栈顶 肯定是 大于或者等于 新来的temperatures[i]了
            indexStack.addLast(i);
            
        }
        
        
        return res;
    }
    
    @Test
    public void test() {
        int[] temperature = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperature)));
    }
}
