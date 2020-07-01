package Hot_100;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/6/28
 * @description:
 * @result:
 */
public class Exe739_Daily_Temperatures {

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        if(length == 1){
            return ans;
        }
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if (T[j] > T[i]){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

}
