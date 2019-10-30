package Chapter1;

import java.util.Arrays;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/30
 * @description:
 * @result:
 */
public class Exe34_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 1 && nums[0] == target){
            ans[0] = 0;
            ans[1] = 0;
            return ans;
        }
        ans[0] = index(nums, target, false);
        ans[1] = index(nums, target, true);
        return ans;
    }

    private int index(int[] nums, int target, boolean direction){
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                index = mid;
            }
            if (direction){
                if (nums[mid] <= target){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                if (nums[mid] >= target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(new Exe34_SearchRange().searchRange(nums, 6)));
    }
}
