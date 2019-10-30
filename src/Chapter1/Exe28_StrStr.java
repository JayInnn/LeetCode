package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/29
 * @description:
 * @result:
 */
public class Exe28_StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        //compute the pattern's failure function
        int[] failure = new int[needle.length()];
        fail(failure, needle);
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else if(j == 0){
                i++;
            }else {
                j = failure[j-1] + 1;
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private void fail(int[] failure, String pat){
        failure[0] = -1;
        int i;
        for(int j = 1; j < pat.length(); j++){
            i = failure[j-1];
            while(pat.charAt(j) != pat.charAt(i+1) && i >= 0)
                i = failure[i];
            if(pat.charAt(j) == pat.charAt(i+1))
                failure[j] = i + 1;
            else
                failure[j] = -1;
        }
    }

    public static void main(String[] args){
        String haystack = "aaaaa";
        String needle = "bba";
        new Exe28_StrStr().strStr(haystack,needle);
    }
}
