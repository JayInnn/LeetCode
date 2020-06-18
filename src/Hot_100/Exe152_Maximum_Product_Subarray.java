package Hot_100;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/6/18
 * @description:
 * @result:
 */
public class Exe152_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            int tmp = 1;
            for (int j = i; j >= 0; j--){
                tmp = tmp * nums[j];
                if (tmp > ans){
                    ans = tmp;
                }
            }
        }
        return ans;
    }

    public int maxProductOptimize(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int imax = 1, imin = 1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            ans = Math.max(imax, ans);
        }
        return ans;
    }
}
