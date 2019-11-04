package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/11/4
 * @description:
 * @result:
 */
public class Exe43_Multiply {
    public String multiply(String num1, String num2) {
        String[] index = new String[10];
        //index the bigger num
        index = num1.length() > num2.length() ? indexString(num1) : indexString(num2);
        String tmp = num1.length() > num2.length() ? num2 : num1;
        String ans = "0";
        for (int i = tmp.length() - 1; i >= 0; i--){
            int k = tmp.charAt(i) - '0';
            StringBuilder sb = new StringBuilder(index[k]);
            int j = tmp.length() - i - 1;
            while (j > 0){
                sb.append("0");
                j--;
            }
            ans = addString(ans, sb.toString());
        }
        return ans;
    }
    private String[] indexString(String num){
        String[] index = new String[10];
        index[0] = "0";
        index[1] = new String(num);
        for (int i = 2; i < 10; i++){
            index[i] = addString(index[i-1], num);
        }
        return index;
    }

    private String addString(String num1, String num2){
        int i = num1.length() - 1, j = num2.length() - 1, tmp = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 && j >= 0){
            int ch1 = num1.charAt(i) - '0';
            int ch2 = num2.charAt(j) - '0';
            int sum = ch1 + ch2 + tmp;
            tmp = sum / 10;
            ans.append(sum % 10);
            i--;
            j--;
        }
        while (i >= 0){
            int ch1 = num1.charAt(i) - '0';
            int sum = ch1 + tmp;
            tmp = sum / 10;
            ans.append(sum % 10);
            i--;
        }
        while (j >= 0){
            int ch2 = num2.charAt(j) - '0';
            int sum = ch2 + tmp;
            tmp = sum / 10;
            ans.append(sum % 10);
            j--;
        }
        if (tmp != 0)
            ans.append(tmp);
        return ans.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(new Exe43_Multiply().multiply("123", "0"));
    }
}
