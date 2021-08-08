package Hot100;

import org.junit.Test;

public class Hot169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count = count + ((num == candidate) ? 1 : -1);
        }
        
        return candidate;
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
