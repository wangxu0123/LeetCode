package Hard;

import org.junit.Test;

public class Hard312 {
    int res = 0;
    boolean[] flag;
    
    public int maxCoins(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        this.flag = new boolean[len];
        dfs(nums, 0, len, 0);
        return res;
    }
    
    public void dfs(int[] nums, int index, int len, int coins) {
        if (index == len - 1) {
            res = Math.max(res, coins);
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (flag[i] == true) {  // 剪枝
                continue;
            }
            
            int leftIndex = i - 1;
            int rightIndex = i + 1;
            while (leftIndex >= 0 && flag[leftIndex] == true) {
                leftIndex--;
            }
            while (rightIndex <= len - 1 && flag[rightIndex] == true) {
                rightIndex++;
            }
            int curCoin = (leftIndex >= 0 ? nums[leftIndex] : 1) * nums[i] * (rightIndex <= len - 1 ? nums[rightIndex] : 1);
            
            flag[i] = true;
            dfs(nums, i, len, coins + curCoin);
            flag[i] = false;
        }
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{3, 1, 5, 8};
//        int[] nums = new int[]{9, 76, 64, 21, 97, 60, 5};
        System.out.println(maxCoins(nums));
    }
}
