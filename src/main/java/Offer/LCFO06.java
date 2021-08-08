package Offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class LCFO06 {
    public int[] reversePrint(ListNode head) {
        
        Stack<Integer> tempStack = new Stack<>();
        
        int i = 0;
        
        while (head != null) {
            
            tempStack.add(head.val);
            
            head = head.next;
            i++;
        }
        int[] res = new int[i];
        for (i = 0; i < res.length; i++) {
            res[i] = tempStack.pop();
        }
        return res;
    }
    
    
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
    
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        
        head.next = node1;
        node1.next = node2;
    
        System.out.println(Arrays.toString(reversePrint(head)));
    
    }
    
}
