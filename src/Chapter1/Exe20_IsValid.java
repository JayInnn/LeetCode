package Chapter1;

import java.util.LinkedList;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/25
 * @description:
 * @result:
 */
public class Exe20_IsValid {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                if (stack.size() == 0)
                    return false;
                char ch = stack.pop();
                if ((s.charAt(i) == ')' && ch != '(') || (s.charAt(i) == ']' && ch != '[') || (s.charAt(i) == '}' && ch != '{'))
                    return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args){
        String s = "{[]}";
        System.out.println(new Exe20_IsValid().isValid(s));
    }
}
