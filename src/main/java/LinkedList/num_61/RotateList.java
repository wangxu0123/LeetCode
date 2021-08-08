package LinkedList.num_61;

import org.junit.Test;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        
        // 如果链表为空，或者只有一个节点，或者传入的k为0，那就不用动 直接返回head就行
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // 定义temp1和count。有两个作用：
        // 循环结束后现在temp1是指向链表最后一个节点的
        // count是用来统计一共有多少个节点的
        ListNode temp1 = new ListNode();
        temp1 = head;
        int count = 1;  // 定义计数count
        // 统计链表的长度
        while (temp1.next != null) {
            temp1 = temp1.next;
            count++;
        }
        
        
        // 然后可以通过判断，过滤掉一些情况
        //  1.如果k大于等于链表长度，说明要移动好几圈，可以直接求余，只移动有效的次数。
        if (k >= count) {
            k = k % count;
            if (k == 0) {  //  2.如果链表长度 与 k 相同（也就是求余之后k=0了），说明链表不用动，直接返回。
                return head;
            }
        }
        
        // temp2是移动到倒数第k+1个节点的，有两个作用：
        //  1.将这个节点的下一个节点next 当成头head
        //  2.用来将这个节点指向空null，也就是当成最后一个节点
        ListNode temp2 = new ListNode();
        temp2 = head;
        // 找到倒数第k-1个位置
        for (int i = 0; i < count - k - 1; i++) {
            temp2 = temp2.next;
        }
        temp1.next = head;
        head = temp2.next;
        temp2.next = null;
        
        return head;
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
    public void test() {
        
        ListNode L5 = new ListNode(5);
        ListNode L4 = new ListNode(4, L5);
        ListNode L3 = new ListNode(3, L4);
        ListNode L2 = new ListNode(2, L3);
        ListNode L1 = new ListNode(1, L2);
        
        ListNode res = rotateRight(L1, 2);
        System.out.println(res.val);
        
    }
    
    
}

