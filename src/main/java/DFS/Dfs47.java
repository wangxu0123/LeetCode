package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dfs47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] flag;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.flag = new boolean[nums.length];
        int resLength = nums.length;
        Arrays.sort(nums);
        dfs(nums, 0, resLength);
        return res;
    }
    
    public void dfs(int[] nums, int index, int resLength) {
        if (path.size() == resLength) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == true || (i > 0 && nums[i] == nums[i - 1] && flag[i - 1] == false)) {
                continue;
            }
            path.add(nums[i]);
            flag[i] = true;
            dfs(nums, i, resLength);
            path.remove(path.size() - 1);
            flag[i] = false;
        }
    }
    
    
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
}
