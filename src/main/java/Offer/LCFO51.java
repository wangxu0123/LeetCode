package Offer;

import org.junit.Test;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 例如：
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class LCFO51 {
    int count = 0;
    
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return count;
    }
    
    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (right < left) {
            return;
        }
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }
    
    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;  // 初始化指向左边数组第一位，然后移动
        int j = mid + 1;  // 初始化指向右边数组第一位，然后移动
        int t = 0;  // 定义temp的移动指针
        while (i <= mid && j <= right) {  // 左或者右，有一方到达 自己部分的边界 了，那就退出循环
            if (arr[i] <= arr[j]) {  // 如果左小于右，那么就把左边这个值放入temp中
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {  // 如果左大于右，那么就把右边这个值放入temp中
                temp[t] = arr[j];
                t += 1;
                j += 1;
                count += mid - i + 1;
            }
        }
        
        // 退出循环后，看看是哪个数组还有值
        while (i <= mid) {  // 这里表示左边还有值，右边已经没了。所以将左边的数直接全部导入
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {  // 这里表示右边还有值，左边已经没了。所以将右边的数直接全部导入
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        
        // 然后将当前temp中的数，导入arr中（要注意tempLeft的含义）
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
    
    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7};
        System.out.println(reversePairs(nums));
    }
    
}
