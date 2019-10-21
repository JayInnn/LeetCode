package Chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/19
 * @description:
 * @result:
 */
public class Exe18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if (length < 4)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < length; j++){
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                int L = j + 1;
                int R = length - 1;
                while (L < R){
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L+1]) L++;
                        while (L < R && nums[R] == nums[R-1]) R--;
                        L++;
                        R--;
                    }
                    else if (sum < target)
                        L++;
                    else
                        R--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(new Exe18_FourSum().fourSum(nums, -1));
    }
}
