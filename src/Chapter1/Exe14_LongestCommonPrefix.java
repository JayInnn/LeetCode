package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/19
 * @description:
 * @result:
 */
public class Exe14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            int j = 0;
            while (j < prefix.length() && j < strs[i].length()){
                if (prefix.charAt(j) == strs[i].charAt(j))
                    j++;
                else break;
            }
            if (j == 0){
                prefix = "";
                break;
            } else{
                prefix = prefix.substring(0,j);
            }
        }
        return prefix;
    }

    public String longestCommonPrefix_simplify(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args){
        String[] strs = {"dog","racecar","car"};
        System.out.println(new Exe14_LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
