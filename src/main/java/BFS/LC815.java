package BFS;

import org.junit.Test;

import java.util.*;

public class LC815 {
    
    int s, t;
    int[][] rs;
    
    public int numBusesToDestination(int[][] _rs, int _s, int _t) {
        rs = _rs;
        s = _s;
        t = _t;
        if (s == t) return 0;
        int ans = bfs();
        return ans;
    }
    
    int bfs() {
        // 记录某个车站可以进入的路线
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 队列存的是经过的路线
        Deque<Integer> d = new ArrayDeque<>();
        // 哈希表记录的进入该路线所使用的距离
        Map<Integer, Integer> m = new HashMap<>();
        int n = rs.length;
        for (int i = 0; i < n; i++) {
            for (int station : rs[i]) {
                // 将从起点可以进入的路线加入队列
                if (station == s) {
                    d.addLast(i);
                    m.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }
        while (!d.isEmpty()) {
            // 取出当前所在的路线，与进入该路线所花费的距离
            int poll = d.pollFirst();
            int step = m.get(poll);
            
            // 遍历该路线所包含的车站
            for (int station : rs[poll]) {
                // 如果包含终点，返回进入该路线花费的距离即可
                if (station == t) return step;
                
                // 将由该线路的车站发起的路线，加入队列
                Set<Integer> lines = map.get(station);
                if (lines == null) continue;
                for (int nr : lines) {
                    if (!m.containsKey(nr)) {
                        m.put(nr, step + 1);
                        d.add(nr);
                    }
                }
            }
        }
        return -1;
    }
    
    @Test
    public void test() {
        int[][] nums = new int[][]{{1, 2, 7}, {3, 6, 7}};
        System.out.println(numBusesToDestination(nums, 1, 6));
    }
    
}
