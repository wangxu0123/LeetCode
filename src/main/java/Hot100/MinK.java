package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MinK {
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (k == 0) {
//            return new int[0];
//        } else if (arr.length <= k) {
//            return arr;
//        }
//
//        // 原地不断划分数组
//        partitionArray(arr, 0, arr.length - 1, k);
//
//        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = arr[i];
//        }
//        return res;
//    }
//
//    public void partitionArray(int[] arr, int lo, int hi, int k) {
//        // 做一次 partition 操作
//        int m = partition(arr, lo, hi);
//        // 此时数组前 m 个数，就是最小的 m 个数
//        if (k == m) {
//            // 正好找到最小的 k(m) 个数
//            return;
//        } else if (k < m) {
//            // 最小的 k 个数一定在前 m 个数中，递归划分
//            partitionArray(arr, lo, m - 1, k);
//        } else {
//            // 在右侧数组中寻找最小的 k-m 个数
//            partitionArray(arr, m + 1, hi, k);
//        }
//    }
//
//    // partition 函数和快速排序中相同，具体可参考快速排序相关的资料
//// 代码参考 Sedgewick 的《算法4》
//    public int partition(int[] arr, int left, int right) {
//        int l = left;
//        int r = right + 1;
//        int pivot = arr[left];
//        while (l < r) {
//            while (arr[++l] < pivot) {
//                if (l == right) {
//                    break;
//                }
//            }
//            while (arr[--r] > pivot) {
//                if (r == left) {
//                    break;
//                }
//            }
//
//            if (l >= r) {
//                break;
//            }
//            swap(arr, l, r);
//        }
//        swap(arr, left, r);
//
//        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
//        return r;
//    }
//
//    public void swap(int[] a, int i, int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
    
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int len = arr.length;
        
        
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, k);
        }
        
        for (int i = k; i < len; i++) {
            if (arr[i] <= arr[0]) {
                arr[0] = arr[i];
                adjustHeap(arr, 0, k);
            }
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        
        return res;
        
    }
    
    
    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
        
    }
    
    
    @Test
    public void test() {
//        int[] arr = {3, 2, 5, 4, 1};
//        int[] arr = {-2, 78, 0, 23, -5, 70, -1, 900, 4561};
//        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int[] arr = {0, 1, 1, 2, 4, 4, 1, 3, 3, 2};
        int k = 6;
        
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }
}
