package Hot100;

import org.junit.Test;

public class Hot215 {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        // 将一个无序数组构造成一个大顶堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, length);
        }
        
        // 构造完成后，开始一个一个拿出最大值
        int temp;
        for (int i = length - 1; i > 0; i--) {
            // 交换首位
            temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            
            // 除掉一个尾，再把剩下的的构造成大顶堆
            adjustHeap(nums, 0, i);
        }
        
        // 到此就得到了nums有序数组
        return nums[length - k];
    }
    
    // 编写 从当前节点 构造一个大顶堆的函数
    public void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k++;
            }
            
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {  // 如果不需要再交换了，就跳出循环
                break;
            }
        }
        nums[i] = temp;
    }
    
    @Test
    public void test() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        
        System.out.println(findKthLargest(nums, 2));
    }
}
