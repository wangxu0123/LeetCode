package Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrder {
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        posterOrder(root);
        return res;
    }
    
    
    public void posterOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;
        TreeNode pre = null;
        
        while (temp != null || !stack.isEmpty()) {
            //将左儿子一路入栈
            while (temp != null) {
                stack.addLast(temp);
                temp = temp.left;
            }
            
            if (!stack.isEmpty()) {
                temp = stack.peekLast();//获取栈顶元素
                
                if (temp.right == null || temp.right == pre) {//栈顶元素没有右儿子 并且 右儿子被访问过
                    //就可以访问栈顶元素了
                    temp = stack.removeLast();
                    res.add(temp.val);
                    
                    pre = temp;//pre标记，表示已访问过
                    temp = null;//temp制空
                } else {//否则表示：栈顶元素有右儿子 并且 右儿子没有被访问过
                    temp = temp.right;
                }
            }
        }
    }
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
        }
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(7);
        TreeNode node3 = new TreeNode(6);
        TreeNode node6 = new TreeNode(8);
        
        
        root.left = node1;
        root.right = node4;
        
        node4.left = node3;
        node4.right = node6;
        
        System.out.println(postorderTraversal(root));
    }
}