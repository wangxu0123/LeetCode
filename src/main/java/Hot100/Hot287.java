package Hot100;

import org.junit.Test;

public class Hot287 {
//    // 二分查找法
//    public int findDuplicate(int[] nums) {
//        int n = nums.length;
//        int l = 1, r = n - 1, ans = -1;
//        while (l <= r) {
//            int mid = (l + r) / 2;
//            int cnt = 0;
//            for (int i = 0; i < n; ++i) {
//                if (nums[i] <= mid) {
//                    cnt++;
//                }
//            }
//            if (cnt <= mid) {
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//                ans = mid;
//            }
//        }
//        return ans;
//    }
    
    // 快慢指针（类似于链表 找环头的题）
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    
    
    @Test
    public void test() {
        int[] coins = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(coins));
    }
}
