package Hot100;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Hot155 {
    Deque<Integer> stack;  // 正常栈
    Deque<Integer> dMin;  // 单调栈
    /** initialize your data structure here. */
    public void MinStack() {
        stack = new LinkedList<>();
        dMin = new LinkedList<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        
        if(dMin.isEmpty() || val <= dMin.peekLast()){
            dMin.addLast(val);
        }
        
    }
    
    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        int x = stack.removeLast();
        if(x == dMin.peekLast()){
            dMin.removeLast();
        }
        // 下面这么写有错误：
        // if(stack.peekLast() == dMin.peekLast()){  // 这句不知道为什么即便真相等了它判断结果也为false
        //     dMin.removeLast();
        // }
        // stack.removeLast();
    }
    
    public int top() {
        if (stack.isEmpty()){
            return -1;
        }
        
        return stack.peekLast();
    }
    
    public int getMin() {
        if (dMin.isEmpty()){
            return -1;
        }
        
        return dMin.peekLast();
    }
    
    @Test
    public void test() {
        MinStack();
        push(512);
        push(-1024);
        push(-1024);
        push(512);
        pop();
        getMin();
        pop();
        getMin();
        pop();
        getMin();
        
    }
}
