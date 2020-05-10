package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-10
 */
public class Exe70_Climbing_Stairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
