package Stack;

import org.junit.Test;

import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // 升级版
        Deque<Integer> stack = new LinkedList<Integer>();
        int len = tokens.length;
        
        for (int i = 0; i < len; i++) {
            if (isNumber(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        return stack.pop();

//        // low版
//        // 然后开始求 逆波兰表达式 的值
//        for (String item : list) {
//            // 首先 判断是不是数字，如果是数字，就压入栈。如果是符号，就计算
//            if (item.matches("-?\\d+")) {
//                stack.push(item);
//            } else {//这里说是符号
//                int num1 = Integer.parseInt(stack.pop());
//                int num2 = Integer.parseInt(stack.pop());
//                if (item.equals("+")) {
//                    res = num1 + num2;
////                    stack.push("" + (num1 + num2));
//                } else if (item.equals("-")) {
//                    res = num2 - num1;
//                } else if (item.equals("*")) {
//                    res = num1 * num2;
//                } else if (item.equals("/")) {
//                    res = num2 / num1;
//                } else {
//                    throw new RuntimeException("错误");
//                }
//                stack.push("" + res);
//            }

//        }

//        return Integer.parseInt(stack.pop());
    }
    
    public static boolean isNumber(String str) {
        return str != "+" && str != "-" && str != "*" && str != "/";
    }
    
    
    @Test
    public void test() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        
        int res = evalRPN(tokens);
        System.out.println(res);
        
    }
}
