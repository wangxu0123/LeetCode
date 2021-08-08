package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Hot448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;  // 因为遍历到某个位置时，其中的数可能已经被增加过，因此需要对n取模来还原出它本来的值
            nums[x] = nums[x] + n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
    
    
    @Test
    public void test() {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }
}

