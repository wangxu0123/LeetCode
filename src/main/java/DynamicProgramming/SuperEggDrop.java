package DynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

// LeetCode887：鸡蛋掉落
public class SuperEggDrop {
    
    // 定义鸡蛋数k和楼层数n
    public static int superEggDrop(int k, int n) {
        
        
        // 判断一下特殊情况，也是作为终止条件的。也就是只有一个鸡蛋的时候，最少次数就是 楼层数。如果楼层为0或者鸡蛋为0，那最少次数结果肯定也是0。
        if (k == 0 || n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        if (k > n) {
            return superEggDrop(k - 1, n);
        }
        
        
        // 因为要判断最坏情况（蛋碎or没碎） 最少次数
        int[] temp = new int[n];  // 用来保存 第一个鸡蛋 从不同楼层扔下的次数结果，最终是取这个数组中 最少的那个当作最终结果（因为最终结果表示：第一个鸡蛋从这个层楼扔，最后次数少）
        // 有几层楼 就要判断几次，然后比较从哪个楼层扔 次数最小，就选哪个
        for (int i = 1; i <= n; i++) {  // 从每层扔的时候，都有两种情况鸡蛋碎还是碎，然后取这两种情况的结果次数的最大（也就是最坏）
            // 进来就表示第一个鸡蛋已经在第i层扔完了，所以现在有两种情况：蛋碎了 or 蛋没碎。这两种情况都要判断，最后取这俩的 最大值 表示最坏结果（这是题目要求最坏结果）
            
            // 1.蛋碎了。
            // 那就说明：
            // 可用鸡蛋数目少了一个变成了k-1个。
            // 要继续判断的楼层数也可以少一点了，变成了i-1。（因为i层往上 包括它自己都不再满足要求了，那就往下判断就行了）
            // 所以递归 判断(k-1, i-1)这种情况，并将结果存入eggBroken 表示当第一个鸡蛋从第i层扔的时候，最少需要多少次。
            int eggBroken = superEggDrop(k - 1, i - 1);
            
            // 2.蛋没碎
            // 那就说明：
            // 可用鸡蛋数目没变，还是k个。
            // 但判断的楼层数还是可以少一点的，变成了n-i。（因为i层往下 包括它自己都不再满足要求了，那就往上判断就行了）
            // 所以递归 判断(k, n-i)这种情况，并将结果存入eggNotBroken 表示当第一个鸡蛋从第i层扔的时候，最少需要多少次。
            int eggNotBroken = superEggDrop(k, n - i);
            
            // 然后将最后结果，选择最差的那个存入temp[i] 表示最坏情况。
            temp[i-1] = 1 + Math.max(eggBroken, eggNotBroken);
        }
        
        return Arrays.stream(temp).min().getAsInt();  // 返回数组中的最小值
        
    }
    
    
    @Test
    public void test() {
        
        
        int k = 2;
        int n = 10;
        
        int f = superEggDrop(k, n);
        System.out.println(f);
    }
    
}
