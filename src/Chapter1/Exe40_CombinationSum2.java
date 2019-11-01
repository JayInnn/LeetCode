package Chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/11/1
 * @description:
 * @result:
 */
public class Exe40_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates.length == 0)
            return ans;
        LinkedList<Integer> stack = new LinkedList<>();
        Arrays.sort(candidates);
        findComb(ans, stack, candidates, target, 0);
        return ans;
    }

    private void findComb(List<List<Integer>> ans, LinkedList<Integer> stack, int[] candidates, int target, int start){
        if (target == 0)
            ans.add(new ArrayList<>(stack));
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++){
            stack.push(candidates[i]);
            findComb(ans, stack, candidates, target - candidates[i], i+1);
            stack.pop();
            while (i < candidates.length - 1 && candidates[i] == candidates[i+1]) i++;
        }
    }
}
