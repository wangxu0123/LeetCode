package Offer;

import org.junit.Test;

public class LCFO33 {
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        return recur(postorder, 0, n - 1);
    }
    
    public boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        
        int flag = left;  // 左子树是否都小于根节点
        while (postorder[flag] < postorder[right]) {
            flag++;
        }
        
        int newRight = flag;  // 右子树是否都大于根节点
        while (postorder[flag] > postorder[right]) {
            flag++;
        }
        
        return flag == right && recur(postorder, left, newRight - 1) && recur(postorder, newRight, right - 1);
    }
    
    
    
    @Test
    public void test() {
        int[] postorder = new int[]{1, 2, 5, 10, 6, 9, 4, 3};
        
        System.out.println(verifyPostorder(postorder));
    }
}
