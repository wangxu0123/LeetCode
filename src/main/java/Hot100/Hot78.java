package Hot100;

import org.junit.Test;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

public class Hot78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); i++) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (bitmask.charAt(j) == '1') {
                    cur.add(nums[j]);
                }
            }
            
            result.add(cur);
        }
        
        return result;
    }
    
    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        
        System.out.println(subsets(nums));
    }
}
