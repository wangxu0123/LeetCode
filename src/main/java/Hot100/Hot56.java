package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Hot56 {
    public int[][] merge(int[][] intervals) {
        //sort to get ordered array
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        List<int[]> path = new ArrayList<>();
        int left = 0, right = 0;
        
        while (right < intervals.length) {
            int leftBound = intervals[left][0];
            int rightBound = intervals[right][1];
            
            while (right < intervals.length && intervals[right][0] <= rightBound) {
                rightBound = Math.max(intervals[right][1], rightBound);
                right++;
            }
            
            path.add(new int[]{leftBound, rightBound});
            left = right;
        }
        
        //copy the result to the array from List
        int[][] res = new int[path.size()][2];
        for (int i = 0; i < path.size(); i++) {
            res[i][0] = path.get(i)[0];
            res[i][1] = path.get(i)[1];
        }
        
        return res;
    }
    
    
    @Test
    public void test() {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
