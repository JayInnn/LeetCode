package Hot_100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/6/20
 * @description:
 * @result:
 */
public class Exe416_Partition_Equal_Subset_Sum {

    public boolean canPartition(int[] nums) {
        if (nums.length == 1){
            return false;
        }
        int sum =0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum % 2 == 1){
            return false;
        }
        sum = sum / 2;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < nums.length; i++){
            Set<Integer> tmpSet = new HashSet<>();
            for (Integer entry : set){
                if (entry + nums[i] == sum){
                    return true;
                }
                if (entry + nums[i] <= sum){
                    tmpSet.add(entry + nums[i]);
                }
                tmpSet.add(entry);
                set = tmpSet;
            }
        }
        return false;
    }

    public boolean canPartitionOptimize(int[] nums) {
        if (nums.length == 1){
            return false;
        }
        int sum =0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if ((sum & 1) == 1){
            return false;
        }
        sum = sum / 2;
        int length = nums.length;
        boolean[][] dp = new boolean[length][sum + 1];

        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < length; i++){
            for (int j = 0; j < sum + 1; j++){
                if (nums[i] == j){
                    dp[i][j] = true;
                }else if (nums[i] < j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[length - 1][sum];
    }

    public boolean canPartitionOptimizeTwo(int[] nums) {
        int length = nums.length;
        if (length == 1){
            return false;
        }
        int sum =0;
        for (int i = 0; i < length; i++){
            sum += nums[i];
        }
        if ((sum & 1) == 1){
            return false;
        }
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i =  1; i < length; i++){
            for (int j = target; j >= nums[i]; j--){
                if (dp[target]){
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

}
