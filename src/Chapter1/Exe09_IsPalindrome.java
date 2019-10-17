package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/17
 * @description:
 * @result:
 */
public class Exe09_IsPalindrome {
    public boolean isPalindrome(int x) {
        String s = new StringBuilder(Integer.toString(x)).reverse().toString();
        int tmp = 0;
        boolean result = true;
        try {
            tmp = Integer.valueOf(s);
        }catch (Exception e){
            result = false;
        }
        return result && tmp == x;
    }
}
