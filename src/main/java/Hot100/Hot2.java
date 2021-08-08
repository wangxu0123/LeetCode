package Hot100;

import org.junit.Test;

public class Hot2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        int sum = 0;
        
        ListNode temp = new ListNode(1);
        ListNode head = temp;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                sum = l2.val + carry;
                carry = sum / 10;
                sum = sum % 10;
                temp.next = new ListNode(sum);
                temp = temp.next;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                carry = sum / 10;
                sum = sum % 10;
                temp.next = new ListNode(sum);
                temp = temp.next;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                carry = sum / 10;
                sum = sum % 10;
                temp.next = new ListNode(sum);
                temp = temp.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }
        return head.next;
    }
    
    public class ListNode {
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
    
    
    
    
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode temp = head;
        while (temp.next != null && temp.next.next != null){
            
            if (temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            
            temp = temp.next;
        }
        
        return head;
    }
    
    @Test
    public void test() {
        ListNode L3 = new ListNode(9);
        ListNode L4 = new ListNode(9, L3);
        ListNode L2 = new ListNode(9, L4);
        
        
        ListNode L6 = new ListNode(9);
        ListNode L5 = new ListNode(9, L6);
        
        addTwoNumbers(L2, L5);
        
    }
    
    
}
