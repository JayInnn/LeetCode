package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/15
 * @description:
 * @result:
 */
public class Exe04_LongestPalindrome {
    public String longestPalindrome_direct(String s) {
        if (s == null || s.length() == 0)
            return "";
        int[] index = new int[2];
        int max = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j++){
                boolean flag = true;
                for (int k = 0; k < (j - i + 1) / 2; k++){
                    if (s.charAt(i + k) != s.charAt(j-k)){
                        flag = false;
                        break;
                    }
                }
                if (flag && max < (j - i + 1)){
                    index[0] = i;
                    index[1] = j;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(index[0], index[1]+1);
    }

    public String longestPalindrome_twoDimension(String s) {
        int length = s.length();
        if (s == null || s.length() == 0)
            return "";
        int[] index = new int[2];
        int max = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--)
            for (int j = i; j < length; j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i) < 2 || dp[i+1][j-1]);
                if (dp[i][j] && max < (j - i + 1)){
                    max = j - i + 1;
                    index[0] = i;
                    index[1] = j;
                }
            }
        return s.substring(index[0], index[1]+1);
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (s == null || s.length() == 0)
            return "";
        int[] index = new int[2];
        int max = 0;
        boolean[] dp = new boolean[length];
        for (int i = length - 1; i >= 0; i--)
            for (int j = length - 1; j >= 0; j--){
                dp[j] = s.charAt(i) == s.charAt(j) && ((j - i) < 3 || dp[j-1]);
                if (dp[j] && (max < j - i + 1)){
                    max = j -i + 1;
                    index[0] = i;
                    index[1] = j;
                }
            }
        return s.substring(index[0], index[1]+1);
    }

    public static void main(String[] args){
        System.out.println(new Exe04_LongestPalindrome().longestPalindrome("CABCBAAAAAA"));
    }
}
