package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-06-13
 */
public class Exe279_Perfect_Squares {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++){
            int temp = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++){
                int num = dp[i - j * j] + 1;
                temp = temp > num ? num : temp;
            }
            dp[i] = temp;
        }
        return dp[n];
    }

    public static void main(String[] args){
        int n = 9;
        System.out.println(new Exe279_Perfect_Squares().numSquares(n));
    }
}
