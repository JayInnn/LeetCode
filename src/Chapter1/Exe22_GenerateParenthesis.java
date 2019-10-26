package Chapter1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/26
 * @description:
 * @result:
 */
public class Exe22_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<List<String>> ans = new ArrayList<>();
        ans.add(Arrays.asList(""));

        for (int i = 1; i <= n; i++){
            ArrayList<String> iList = new ArrayList<>();
            for (int j = 0; j < i; j++){
                List<String> p = ans.get(j);
                List<String> q = ans.get(i - 1 - j);
                for (String entryP : p)
                    for (String entryQ : q)
                        iList.add("(" + entryP + ")" + entryQ);
            }
            ans.add(iList);
        }
        return ans.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new Exe22_GenerateParenthesis().generateParenthesis(8));
    }
}
