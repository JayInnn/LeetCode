package Chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/11/1
 * @description:
 * @result:
 */
public class Exe46_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums)
            numsList.add(num);
        perm(ans, numsList, 0, nums.length);
        return ans;
    }

    private void perm(List<List<Integer>> ans, ArrayList<Integer> nums, int i, int n){
        if (i == n)
            ans.add(new ArrayList<Integer>(nums));
        for (int j = i; j < n; j++){
            Collections.swap(nums, i, j);
            perm(ans, nums, i+1, n);
            Collections.swap(nums, i, j);
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        new Exe46_Permute().permute(nums);
    }
}
