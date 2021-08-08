package Offer;

import org.junit.Test;
//剑指 Offer 11. 旋转数组的最小数字
public class LCFO11 {
    
    public int minArray(int[] numbers) {
        
        int left = 0;
        int right = numbers.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
        
    }
    
    
    @Test
    public void test() {

//        int[] numbers = {3, 4, 5, 1, 2};
        int[] numbers = {4, 4, 4, 6, 4};//特殊，right--把本应该找的最右边的4剪掉了，但结果还能返回4，是因为左边的第一个数一定是大于等于4的，而mid值现在就等于了4，mid肯定是大于等于left的，所以left也为4，所以最后返回的是left的4
        
        System.out.println(minArray(numbers));
    }
}
