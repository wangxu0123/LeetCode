package Test;

import org.junit.Test;

public class LC875 {
    public int minEatingSpeed(int[] piles, int h) {
        int leftK = 1;
        int rightK = Integer.MAX_VALUE;
        
        while (leftK < rightK){
            int midK = leftK + (rightK - leftK) / 2;
            if (!isPossable(piles, midK, h)){
                leftK = midK + 1;//这里表示之前的midk时间不够，所以要+1继续判断
            }else {// 这里表示midk时间够了，所以要继续往下判断还有没有更小的
                rightK = midK;
            }
        }
        
        return leftK;
    }
    
    public boolean isPossable(int[] piles, int K, int H){
         int sum = 0;
         for (int pile : piles){
             if (pile % K == 0){
                 sum = sum + pile / K;
             }else if (pile < K){
                 sum = sum + 1;
             }else {
                 sum = sum + pile / K + 1;
             }
         }
         return sum <= H ? true : false;
//        int time = 0;
//        for (int p: piles)
//            time += (p-1) / K + 1;
//        return time <= H;
    }
    
    @Test
    public void test() {
        int[] nums = new int[]{1000000000};
        System.out.println(minEatingSpeed(nums,2));
    }
}
