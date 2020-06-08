package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-06-08
 */
public class Exe647_Palindromic_Substrings {

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }
        int length = s.length();
        int ans = 1;
        for (int i = 1; i < length; i++){
            char ch = s.charAt(i);
            int num = 0;
            for (int j = i - 1; j >= 0; j--){
                if (s.charAt(j) == s.charAt(i) && judgePalindromic(j, i, s)){
                    num ++;
                }
            }
            ans = ans + 1 + num;
        }
        return ans;
    }

    private boolean judgePalindromic(int j, int i, String s){
        for (int k = 0; k <= (i - j) / 2 ; k++){
            if (s.charAt(j+k) != s.charAt(i-k)){
                return false;
            }
        }
        return true;
    }

    public int countSubstringsOptimize(String s) {
        int N = s.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }


    public static void main(String[] args){
        String s = "xkjkqlajprjwefilxgpdpebieswu";
        System.out.println(new Exe647_Palindromic_Substrings().countSubstringsOptimize(s));
    }
}
