package Chapter1;

import java.util.Arrays;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/29
 * @description:
 * @result:
 */
public class Exe31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int i, better = -1, value = Integer.MAX_VALUE;
        for (i = nums.length - 2; i >= 0; i--){
            better = i;
            for (int j = i + 1; j < nums.length; j ++)
                if (nums[j] > nums[i] && (nums[j] - nums[i] < value)){
                    better = j;
                    value = nums[j] - nums[i];
                }
            if (better != i){
                int tmp = nums[i];
                nums[i] = nums[better];
                nums[better] = tmp;
                better = i;
                break;
            }
        }
        if (i != -1)
            Arrays.sort(nums, better+1, nums.length);
        else
            Arrays.sort(nums, better, nums.length);
    }

    public static void main(String[] args){
        int[] nums = {1,3,2};
        new Exe31_NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
