package Offer;

import org.junit.Test;

import java.util.*;

public class LCFO32 {
    //    public int[] levelOrder(TreeNode root) {
//        if (root == null) {  // 空树则返回空数组
//            return new int[0];
//        }
//        Queue<TreeNode> q = new LinkedList<>(); // 借助一个队列，通过 BFS 实现按层遍历二叉树
//        ArrayList<Integer> tmp = new ArrayList<>(); // 申请一个动态数组 ArrayList 动态添加节点值
//
//        q.offer(root); // 根结点先入队
//        while (q.size() != 0) {
//            TreeNode node = q.poll(); // 取出当前队首元素
//            tmp.add(node.val);
//            if (node.left != null) q.offer(node.left); // 左子节点入队
//            if (node.right != null) q.offer(node.right); // 右子节点入队
//        }
//
//        // 将 ArrayList 转为 int数组并返回
//        int[] res = new int[tmp.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = tmp.get(i);
//        }
//        return res;
//}
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.addFirst(root);
        }
        
        // 简单来说就是：队列永远是正常加入正常弹出，弹出来之后把自己赋给node。
        // 然后node按前后要求把自己的值加入到tmp中。
        // 然后在把自己的左右孩子正常入队。
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                
                TreeNode node = queue.removeFirst();
                
                if (res.size() % 2 == 0) {  // 偶数层(0 2 4...)(也就是追加在后面，即正序)
                    tmp.addLast(node.val);
                } else {  // 奇数层(1 3 5...)(也就是在最开头插入数据，相当于倒叙了)
                    tmp.addFirst(node.val);
                }
                
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(tmp);
        }
        
        return res;
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
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode leftLeft = new TreeNode(12);
        TreeNode leftRight = new TreeNode(13);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        
        root.left = left;
        root.right = right;
        
        left.left = leftLeft;
        left.right = leftRight;
        
        right.left = rightLeft;
        right.right = rightRight;
    
        System.out.println(levelOrder(root));
    
    
    }
}
