package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot406 {
    public int[][] reconstructQueue(int[][] people) {
        // 排序，如果第0个位置的值相等，那就按第1个位置升序排列，否则按第0个位置降序排列。
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        
        List<int[]> res = new ArrayList<>();
        
        for (int[] p : people) {  // 因为现在p，前面的都是比p大的，所以p[1]就表示需要前面有几个比它大，所以就放在p[1]位置
            res.add(p[1], p);  // 往p[1]位置，加入p这个值
        }
        
        return res.toArray(new int[people.length][2]);
    }
    
    @Test
    public void test() {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        
        reconstructQueue(people);
        
    }
}
