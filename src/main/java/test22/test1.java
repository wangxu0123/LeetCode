package test22;

import org.junit.Test;

public class test1 {
    
    public int find(int[] a, int k) {
        int len = a.length;
        
        if (k > len || k <= 0) {
            return -1;
        }
        
        k = len - k;
        return isK(a, 0, len - 1, k);
    }
    
    private int isK(int[] a, int l, int r, int k) {
        int tempRes = quickSort(a, l, r);
        if (tempRes == k) {
            return a[tempRes];
        } else {
            return tempRes < k ? isK(a, tempRes + 1, r, k) : isK(a, l, tempRes - 1, k);
        }
    }
    
    public int quickSort(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;
        for (int j = l; j <= r; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }
    
    
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    @Test
    public void test22() {
        int[] a = new int[]{3, 4, 1, 5, 6, 7};
        System.out.println(find(a, 3));
    }
    
}
