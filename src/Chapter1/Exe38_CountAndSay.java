package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/31
 * @description:
 * @result:
 */
public class Exe38_CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String lastString = countAndSay(n-1);
        //deal with old, and return new
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lastString.length(); ){
            int j = i + 1;
            while (j < lastString.length() && lastString.charAt(j) == lastString.charAt(i))
                j++;
            stringBuilder.append(j - i).append(lastString.charAt(i));
            i = j;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        System.out.println(new Exe38_CountAndSay().countAndSay(1));
        System.out.println(new Exe38_CountAndSay().countAndSay(2));
        System.out.println(new Exe38_CountAndSay().countAndSay(3));
        System.out.println(new Exe38_CountAndSay().countAndSay(4));
        System.out.println(new Exe38_CountAndSay().countAndSay(5));
        System.out.println(new Exe38_CountAndSay().countAndSay(6));
    }
}
