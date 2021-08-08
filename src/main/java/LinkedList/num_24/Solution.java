package LinkedList.num_24;

import org.junit.Test;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;  // 新链表（一开始为0-> 1-2-3-4）
        ListNode temp = pre;  // 辅助移动节点temp
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;  // start为 节点1
            ListNode end = temp.next.next;  // end为 节点2
            temp.next = end;  // 将temp变成0-> 2-3-4，end为 2-3-4。（此时pre也变成了0-> 2-3-4）
            start.next = end.next;  // 将 3-4 变成 1-3-4，现在start变成了 1-3-4
            end.next = start;  // 将1-3-4 与end的下一个节点相连，现在end变成了 2-1-3-4。（此时pre也变成了0-> 2-1-3-4）
            temp = start;  // 将 1-3-4 给temp（也就是后移temp）
        }
        return pre.next;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    @Test
    public void test(){
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode = swapPairs(listNode1);
        System.out.println(listNode);
    
    }
    
    @Test
    public void test1(){
        ListNode listNode4 = new ListNode(8);
        ListNode listNode3 = new ListNode(7, listNode4);
        ListNode listNode2 = new ListNode(6, listNode3);
        ListNode listNode1 = new ListNode(5, listNode2);
        ListNode listNode = swapPairs(listNode1);
        System.out.println(listNode);
        
    }
    
    
}




