package Hot100;


import org.junit.Test;

public class Hot98 {
    TreeNode temp = null;
    boolean left = true;
    boolean right = true;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isValidBSTHelper(root);
        
    }
    
    
    public boolean isValidBSTHelper(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        left = left && isValidBSTHelper(root.left);
        
        if (temp == null) {
            temp = root;
        } else if (temp.val < root.val) {
            temp.val = root.val;
        } else {
            return false;
        }
        
        right = right && isValidBSTHelper(root.right);
        
        return left && right;
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
//        TreeNode root = new TreeNode(5);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(6);
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(7);
        TreeNode node3 = new TreeNode(6);
        TreeNode node6 = new TreeNode(8);
        
        
        root.left = node1;
        root.right = node4;
        
        node4.left = node3;
        node4.right = node6;
        
        System.out.println(isValidBST(root));
    }
}
