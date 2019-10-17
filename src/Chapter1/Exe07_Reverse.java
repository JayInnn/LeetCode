package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/17
 * @description:
 * @result:
 */
public class Exe07_Reverse {
    public int reverse(int x) {
        int result = -1;
        int tmp = x > 0 ? x : -x;
        String string = Integer.toString(tmp);
        try {
            result = Integer.valueOf(new StringBuilder(string).reverse().toString());
        }catch (Exception e){
            result = 0;
        }
        return x > 0 ? result : -result;
    }

    public static void main(String[] args){
        System.out.println(new Exe07_Reverse().reverse(-1234567));
    }
}
