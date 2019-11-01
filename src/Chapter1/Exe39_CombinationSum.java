package Chapter1;

import java.util.*;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/11/1
 * @description:
 * @result:
 */
public class Exe39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates.length == 0)
            return ans;
        LinkedList<Integer> stack = new LinkedList<>();
        Arrays.sort(candidates);
        comb(ans, candidates, stack, target, 0);
        return ans;
    }

    private void comb(List<List<Integer>> ans, int[] candidates, LinkedList<Integer> stack, int target, int start){
        if (target == 0)
            ans.add(new ArrayList<Integer>(stack));
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++){
            stack.push(candidates[i]);
            comb(ans, candidates, stack, target - candidates[i], i);
            stack.pop();
        }
    }

    public static void main(String[] args){
        int[] candidates = {8,7,4,3};
        System.out.println(new Exe39_CombinationSum().combinationSum(candidates, 11));
    }
}
