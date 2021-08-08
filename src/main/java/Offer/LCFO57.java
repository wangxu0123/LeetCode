package Offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCFO57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1;
        int right = 1;
        int sum = 0;
        while(left <= target / 2){
            
            if(sum < target){
                sum = sum + right;
                right++;
            }else if(sum > target){
                sum = sum - left;
                left++;
            }
            
            if(sum == target){
                int[] resTemp = new int[right - left];
                for(int k = left; k < right; k++){//左闭右开
                    resTemp[k - left] = k;
                }
                
                res.add(resTemp);
                
                sum = sum - left;
                left++;
            }
            
        }
        
        return res.toArray(new int[res.size()][]);
        
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
    }
}

