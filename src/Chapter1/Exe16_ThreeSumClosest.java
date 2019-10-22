package Chapter1;

import java.util.Arrays;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/22
 * @description:
 * @result:
 */
public class Exe16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++){
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target)
                    R--;
                else if (sum < target)
                    L++;
                else
                    return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
