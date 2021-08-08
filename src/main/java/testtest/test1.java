package testtest;

import java.util.HashMap;
import java.util.Map;

public class test1 {//3 2 1 5 6 9 10
    public int[] towSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(nums[0], 0);
        
        
        for (int i = 1; i < nums.length; i++){
            
            int tempTarget = target - nums[i];
            
            if (map.containsKey(tempTarget)){
                return new int[]{map.get(tempTarget), i};
            }
    
            map.put(nums[i], i);
        }
        
        return new int[0];
    }
    
}
