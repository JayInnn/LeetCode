package Hot_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : YCKJ2794
 * @since : 2020-06-14
 */
public class Exe560_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = i; j >= 0; j--){
                sum = sum + nums[j];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySumOptimize(int[] nums, int k) {
        int count = 0, sum = 0;

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {100,1,2,3,4};
        int k = 6;
        System.out.println(new Exe560_Subarray_Sum_Equals_K().subarraySumOptimize(nums, k));
    }

}
