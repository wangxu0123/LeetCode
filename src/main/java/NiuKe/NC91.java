package NiuKe;

import org.junit.Test;

import java.util.Arrays;

public class NC91 {
    public int[] LIS(int[] arr) {
        int n = arr.length;
        if (n == 0)    //特判空情况，方便后面处理
            return new int[0];
        
        int[] ls = new int[n];    //注意不能用list，会超时。所以直接开一个大数组，动态扩张
        int[] dp = new int[n];
        
        int l = 1;    //ls递增序列的实际长度
        ls[0] = arr[0];
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            if (ls[l - 1] < arr[i]) {
                ls[l++] = arr[i];    //直接加入序列
                dp[i] = l;    //dp[i]对应的序列是整个ls
            } else {
                int j = 0, k = l - 1;
                int ind = 0;
                //找ls中第一个 >= arr[i]的（必定存在，因为保证ls的最后一个 >= arr[i]）
                while (j <= k) {
                    int m = j + (k - j) / 2;
                    if (ls[m] >= arr[i]) {
                        ind = m;
                        k = m - 1;
                    } else {
                        j = m + 1;
                    }
                }
                ls[ind] = arr[i];    //找到位置后替换掉，注意是替换不是插入
                //ls序列的总长不变，但是为了复用原序列一些 < arr[i]的结果，选择二分把arr[i]替换到合适的位置
                //所以dp[i]对应的序列其实是ls的[0, ind]部分（要保证序列的最后是arr[i]），即长度为ind + 1
                dp[i] = ind + 1;
            }
        }
        
        //这里其实可以复用ls来填充的，但是用ans是为了说明求最后的子序列和ls无关
        //ls只是为了上面求dp的复杂度从O(n ^ 2)降低为O(n * logn)
        //这里的求法是倒着遍历，找到满足长度的dp就记录，然后更新。（即同样值的dp，选尽量靠右边的）
        int[] ans = new int[l];
        for (int i = n - 1, j = l; i >= 0; i--) {
            if (dp[i] == j) {
                ans[--j] = arr[i];
            }
        }
        
        return ans;
    }
    
    
    @Test
    public void test() {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int k = 6;
        
        System.out.println(Arrays.toString(LIS(arr)));
    }
}
