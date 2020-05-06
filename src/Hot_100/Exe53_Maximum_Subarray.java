package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-06
 */
public class Exe53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre = 0;
        for (int val : nums){
            pre = Math.max(val, val + pre);
            max = Math.max(max, pre);
        }
        return max;
    }
}
