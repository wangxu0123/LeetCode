package Offer;

import org.junit.Test;

import java.util.Arrays;

public class LCFO26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    
    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
    
    @Test
    public void test() {
        TreeNode rootA = new TreeNode(3);
        TreeNode leftA = new TreeNode(4);
        TreeNode rightA = new TreeNode(5);
        TreeNode leftAA = new TreeNode(1);
        TreeNode rightAA = new TreeNode(2);
        
        rootA.left = leftA;
        rootA.right = rightA;
        leftA.left = leftAA;
        leftA.right = rightAA;
        
        
        TreeNode rootB = new TreeNode(4);
        TreeNode leftB = new TreeNode(1);
        
        rootB.left = leftB;
        
        
        System.out.println(isSubStructure(rootA, rootB));
    }
}
