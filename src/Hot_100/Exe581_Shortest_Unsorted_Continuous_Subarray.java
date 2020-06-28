package Hot_100;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/6/28
 * @description:
 * @result:
 */
public class Exe581_Shortest_Unsorted_Continuous_Subarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i - 1]){
                max = i;
                for (int j = i; j >= 0; j--){
                    if (j >= 1 && nums[j] < nums[j - 1]){
                        int tmp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = tmp;
                    }else {
                        min = Math.min(min, j);
                        break;
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE){
            return 0;
        }
        return max - min + 1;
    }

    public int findUnsortedSubarrayOptimizer(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int low = -1, high = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i< nums.length; i++){
            if (nums[i] < max){
                high = i;
            }
            max = Math.max(max, nums[i]);
        }
        for (int j = nums.length - 1; j >= 0; j--){
            if (nums[j] > min){
                low = j;
            }
            min = Math.min(min, nums[j]);
        }
        return high > low ? high - low + 1 : 0;
    }


        public static void main(String[] args){
//        int[] nums = {2,6,3,4,8,10};
//        int[] nums = {2,3,3,2,4};
        int[] nums = {2,1};
        System.out.println(new Exe581_Shortest_Unsorted_Continuous_Subarray().findUnsortedSubarray(nums));
    }
}
