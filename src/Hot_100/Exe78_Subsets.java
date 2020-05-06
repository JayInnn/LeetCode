package Hot_100;

import java.util.*;

/**
 * @author : YCKJ2794
 * @since : 2020-04-29
 */
public class Exe78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length == 0){
            return result;
        }
        for (int val : nums){
            ArrayList<List<Integer>> list = new ArrayList<>();
            for (int i = 0 ; i < result.size(); i++){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.addAll(result.get(i));
                temp.add(val);
                list.add(temp);
            }
            result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(new Exe78_Subsets().subsets(nums));
    }
}
