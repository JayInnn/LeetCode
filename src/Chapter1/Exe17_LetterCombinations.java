package Chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/22
 * @description:
 * @result:
 */
public class Exe17_LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        boolean flag = true;
        if (digits == null || digits.length() == 0)
            return ans;

        for (int i = digits.length() - 1; i >= 0; i--){
            int num = digits.charAt(i) - '0';
            String str = map[num - 2];
            for (int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                if (flag){
                    if (ans.size() == 0)
                        tmp.add(String.valueOf(ch));
                    else {
                        for (String entry : ans)
                            tmp.add(String.valueOf(ch) + entry);
                    }
                }else {
                    for (String entry : tmp)
                        ans.add(String.valueOf(ch) + entry);
                }
            }
            if (flag){
                ans.clear();
                flag = false;
            }else {
                tmp.clear();
                flag = true;
            }
        }
        return flag ? ans : tmp;
    }

    public static void main(String[] args){
        String digits = "23";
        System.out.println(new Exe17_LetterCombinations().letterCombinations(digits));
    }
}
