package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/15
 * @description:
 * @result:
 */
public class Exe03_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int k = 0, max = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = k; j < i; j++)
                if (chars[j] == chars[i]){
                    k = j + 1;
                    break;
                }
            max = max > (i - k + 1) ? max : (i - k + 1);
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(new Exe03_LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}
