package Offer;

import org.junit.Test;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */

public class LCFO09 {
    
    
    @Test
    public void test(){
        CQueue obj = new CQueue();
        System.out.println(obj.deleteHead());
        obj.appendTail(5);
        obj.appendTail(2);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }
    
}


class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    
    public CQueue() {
    
    }
    
    public void appendTail(int value) {
        
        stack1.push(value);
        
        
    }
    
    public int deleteHead() {
        
        // 如果第二个栈不为空，直接弹出
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else if (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            
            return stack2.pop();
        }
        
        return -1;
        
    }
}