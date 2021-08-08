package Offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LCFO59 {
    //    public int[] maxSlidingWindow(int[] nums, int k) {
//        //单调队列
//        //下面是要注意的点：
//        //队列按从大到小放入
//        //如果首位值（即最大值）不在窗口区间，删除首位
//        //如果新增的值小于队列尾部值，加到队列尾部
//        //如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
//        //如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小
//        if (nums.length == 0) return nums;
//
//        Deque<Integer> deque = new LinkedList<>();
//        int[] arr = new int[nums.length - k + 1];
//        int index = 0;  //arr数组的下标
//        //未形成窗口区间
//        for (int i = 0; i < k; i++) {
//            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
//            //一直循环删除到队列中的值都大于当前值，或者删到队列为空
//            while (!deque.isEmpty() && nums[i] > deque.peekLast()) deque.removeLast();
//            //执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
//            deque.addLast(nums[i]);
//        }
//        //窗口区间刚形成后，把队列首位值添加到队列中
//        //因为窗口形成后，就需要把队列首位添加到数组中，而下面的循环是直接跳过这一步的，所以需要我们直接添加
//        arr[index++] = deque.peekFirst();
//        //窗口区间形成
//        for (int i = k; i < nums.length; i++) {
//            //i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
//            if (deque.peekFirst() == nums[i - k]) deque.removeFirst();
//            //删除队列中比当前值大的值
//            while (!deque.isEmpty() && nums[i] > deque.peekLast()) deque.removeLast();
//            //把当前值添加到队列中
//            deque.addLast(nums[i]);
//            //把队列的首位值添加到arr数组中
//            arr[index++] = deque.peekFirst();
//        }
//        return arr;
//    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]（类似最大那个题，如果现在要删的数 恰好也在单调栈中，单调栈中也要把它删掉）
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }
            
            // 保持 deque 单调递减（类似最大那个题）
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            
            deque.addLast(nums[j]);
            
            // 记录窗口最大值
            if (i >= 0) {
                res[i] = deque.peekFirst();
            }
            
        }
        return res;
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
