package Chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/11/2
 * @description:
 * @result:
 */
public class Exe47_PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;
        ArrayList<Integer> numList = new ArrayList<>();
        for (int num : nums)
            numList.add(num);
        findPermute(ans, numList, 0, nums.length);
        return ans;
    }
    private void findPermute(List<List<Integer>> ans, ArrayList<Integer> numList, int start, int n){
        if (start == n)
            ans.add(new ArrayList<>(numList));
        for (int i = start; i < n; i++){
            if (!isRepeat(numList, start, i)){
                Collections.swap(numList, start, i);
                findPermute(ans, numList, start + 1, n);
                Collections.swap(numList, start, i);
            }
        }
    }
    private boolean isRepeat(ArrayList<Integer> numList, int start, int n){
        int tmp = numList.get(n);
        for (int i = start; i < n; i++)
            if (numList.get(i) == tmp)
                return true;
        return false;
    }

    public static void main(String[] args){
        int[] nums = {2,2,1,1};
        System.out.println(new Exe47_PermuteUnique().permuteUnique(nums));
    }
}
