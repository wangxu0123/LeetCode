package Hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Hard239 {
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
