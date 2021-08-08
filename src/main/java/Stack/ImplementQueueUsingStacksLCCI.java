package Stack;

import org.junit.Test;

import java.util.Stack;

public class ImplementQueueUsingStacksLCCI {
    
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacksLCCI() {
    
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()){
            return stack2.peek();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    @Test
    public void test(){
        ImplementQueueUsingStacksLCCI queue = new ImplementQueueUsingStacksLCCI();
        
        queue.push(1);
        queue.push(2);
        queue.peek();
        queue.push(3);
        System.out.println(queue.peek());
    
    }
    
}
