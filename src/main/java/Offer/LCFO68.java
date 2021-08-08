package Offer;

import org.junit.Test;

public class LCFO68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        
        TreeNode findLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode findRight = lowestCommonAncestor(root.right, p, q);
        
        if (findLeft != null && findRight != null)
            return root;
        else if (findLeft == null)
            return findRight;
        else
            return findLeft;
        
    }
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
        
        @Override
        public String toString() {
            return "val = " + val;
        }
    }
    
    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        
        root.left = node5;
        root.right = node1;
        
        node5.left = node6;
        node5.right = node2;
        
        node2.left = node7;
        node2.right = node4;
        
        node1.left = node0;
        node1.right = node8;
        
        
        System.out.println(lowestCommonAncestor(root, node6, node4));

    }
    
}