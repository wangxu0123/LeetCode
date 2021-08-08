package LinkedList;

import LinkedList.num_61.RotateList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//消消乐，连续四个一样就消除
public class XiaoXiaoLe {
    public static String xiaoXiaoLe(int[] arr) {
        int count = 1;
//        int[] res = new int[arr.length];
        StringBuffer stringBuffer = new StringBuffer();
        ListNode listNode = new ListNode(arr[0], new ListNode(arr[1]));
        ListNode temp1 = listNode.next;
        // 循环完成就把数组转化成链表了
        for (int i = 2; i < arr.length; i++) {
            temp1.next = new ListNode(arr[i]);
            temp1 = temp1.next;
        }
        
        // 然后用temp1和temp2开始消除
        temp1 = listNode;
        ListNode temp2 = listNode;
        
        
        while (true) {
            if (temp2.next.next.next != null) {
                if (temp2.val == temp2.next.val) {
                    if (temp2.next.val == temp2.next.next.val) {
                        if (temp2.next.next.val == temp2.next.next.next.val) {
                            return null;
                        }
                    }
                    
                }
            }
            
            
            if (temp2.next == null || temp2.next.next == null || temp2.next.next.next == null) {
                temp2 = listNode;
                while (temp2 != null) {
                    stringBuffer.append(temp2.val);
                    temp2 = temp2.next;
                }
                return stringBuffer.toString();
            }
            
            
            if (temp2.next.val == temp2.next.next.val) {
                temp2 = temp2.next;  // 这个有问题
                while (temp2.val == temp2.next.val) {
                    count += 1;
                    temp2 = temp2.next;
                }
                
            } else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            
            if (count < 4) {
                temp1 = temp2;
                count = 1;
            }
            if (count >= 4) {
                if (temp1.val == temp2.val) {
                    temp1 = temp2.next;
                    temp2 = temp2.next;
                } else {
                    temp1.next = temp2.next;
                    count = 1;
                    temp1 = listNode;
                    temp2 = listNode;
                }
                
                
            }
            
        }
        
        
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
//        int[] arr = {2, 1, 1, 0, 0, 0, 0, 1, 1, 2, 1, 1, 1, 1, 2};
//        int[] arr = {2, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 3, 3, 2, 1, 1, 1, 1, 2, 2};
        int[] arr = {2, 3, 3, 3, 4, 3, 5, 5, 6, 6, 6, 6, 6, 6, 5, 5, 7};
        
        System.out.println(xiaoXiaoLe(arr));
    }
    
}
