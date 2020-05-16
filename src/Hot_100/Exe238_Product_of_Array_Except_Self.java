package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-16
 */
public class Exe238_Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int temp = 1;
        for (int i = 0; i < n; i++){
            ans[i] = temp;
            for (int j = 0; j < i; j++){
                ans[j] = ans[j] * nums[i];
            }
            temp = temp * nums[i];
        }
        return ans;
    }

    public int[] productExceptSelfOptimize(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for (int i = 1; i < n; i++){
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        int temp = 1;
        for (int i = n - 1; i >= 0; i--){
            ans[i] = temp * ans[i];
            temp = temp * nums[i];
        }

        return ans;
    }
}
