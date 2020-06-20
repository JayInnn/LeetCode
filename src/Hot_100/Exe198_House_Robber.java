package Hot_100;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/6/20
 * @description:
 * @result:
 */
public class Exe198_House_Robber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int ans = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++){
            int max = 0;
            for (int j = 0; j < i-1; j++){
                max = Math.max(max, dp[j]);
            }
            dp[i] = max + nums[i];
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public int robOptimizeone(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[dp.length - 1];
    }

    public int robOptimizeoneTwo(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            int tmp = second;
            second = Math.max(first + nums[i], tmp);
            first = tmp;
        }
        return second;
    }
}
