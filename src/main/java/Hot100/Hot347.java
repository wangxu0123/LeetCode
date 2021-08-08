package Hot100;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Hot347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 定义一个hashmap来初始化每个数 出现的频次，key是数值，value的频次
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] list = new ArrayList[nums.length + 1];
        // 让数字key 出现的频次value 作为桶的索引index
        for (int num : hashMap.keySet()) {
            int i = hashMap.get(num);  // i表示当前key（num）出现的次数
            // 如果当前桶当中还未建立对应的桶表 我们就初始化一个
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(num);
        }
        
        // 下面就可以得到前k个出现最多的
        int[] res = new int[k];
        int i = 0;
        for (int t = nums.length; t >= 0; t--) {
            if (list[t] != null) {
                for (int j = 0; j < list[t].size() && i < k; j++) {
                    res[i] = list[t].get(j);
                    i++;
                }
            }
        }
        return res;
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
