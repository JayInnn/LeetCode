package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/17
 * @description:
 * @result:
 */
public class Exe06_Convert {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1)
            return s;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++)
            for (int j = i; j < s.length(); ){
                stringBuilder.append(s.charAt(j));
                if (i == 0 || i == numRows - 1){
                    j += 2 * numRows - 2;
                }else {
                    j += 2 * numRows - 2 * (i + 1);
                    if (j < s.length())
                        stringBuilder.append(s.charAt(j));
                    j += 2 * i;
                }
            }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        String s = "LEETCODEISHIRING";
        System.out.println(new Exe06_Convert().convert(s, 2));
    }
}
