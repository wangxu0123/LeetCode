package Hot100;

import org.junit.Test;

import java.util.*;

public class Hot20 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.removeLast();
            } else {
                stack.addLast(ch);
            }
        }
        return stack.isEmpty();
    }
    
    
    @Test
    public void test() {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
