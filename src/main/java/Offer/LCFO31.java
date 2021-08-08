package Offer;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LCFO31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new LinkedList<>();
        
        int i = 0;
        for (int num : pushed) {
            stack.addLast(num);
            while (!stack.isEmpty() && stack.peekLast() == popped[i]) {
                stack.removeLast();
                i++;
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Test
    public void test() {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 3, 5, 2, 1};
        
        System.out.println(validateStackSequences(pushed, popped));
    }
}
