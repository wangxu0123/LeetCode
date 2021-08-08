package LinkedList.CycleLCCI;

import com.sun.media.sound.SF2InstrumentRegion;
import org.junit.Test;

// 环路检测（检测环路的一个头节点）

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode pos = new ListNode(-1);
    
        // 如果链表为空
        if (head == null){
            return null;
        }
        
        // 如果链表只有一个节点
        if (head.next == null){
            return null;
        }
        
        //  如果链表有两个节点
        if (head.next.next == null){
            return null;
        }
        
        // 定义快慢指针，判断链表是不是有环
        ListNode fast = head.next;
        ListNode slow = head;
        
        ListNode temp = null;
        
        while (true){
            if (fast.next == null || fast.next.next == null || slow.next == null){
                return null;
            }
            
            if (fast == slow){
                temp = fast;
                fast = fast.next;
                slow = head;
                
                break;
            }
            
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // 开始找 环形链表的 头节点
        while (true){
            
             // 如果没找到，那么slow后移一位
             if (fast == temp){
                 slow = slow.next;
             }
             
             // 如果找到了，那就打破循环返回pos；
             if (fast == slow){
                 pos = slow;
                 break;
             }
             
             fast = fast.next;
            
        }
        
        
        return pos;
    }
    
    
    
    
    
    
    
    
    // 链表类
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    
    @Test
    public void test(){
        ListNode listNode3 = new ListNode(-4);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode0 = new ListNode(3);
        
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;
        
        ListNode test = detectCycle(listNode0);
        System.out.println(test.val);
        
    }
    
    @Test
    public void test1(){
        
        ListNode listNode0 = new ListNode(1);
    
        ListNode test = detectCycle(listNode0);
        System.out.println(test.val);
    }
    
}
