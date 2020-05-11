package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-11
 */
public class Exe338_Counting_Bits {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];

        for (int i = 0; i <= num; i++){
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    public int[] countBits_Optimize_1(int num){
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        while (b <= num){
            while (i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;
            b <<= 1;
        }

        return ans;
    }

    public int[] countBits_Optimize_2(int num) {
        int dp[] = new int[num+1];
        for (int i = 0; i <= num/2; i++) {
            dp[i*2] = dp[i];
            if(i*2+1 <= num){
                dp[i*2+1] = dp[i] + 1;
            }
        }
        return dp;
    }

    public static void main(String[] args){

    }

}
