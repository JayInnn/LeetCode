package Hot_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : YCKJ2794
 * @since : 2020-06-15
 */
public class Exe1248_Count_Number_of_Nice_Subarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0){
                sum ++;
            }
            if(map.containsKey(sum - k)){
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(new Exe1248_Count_Number_of_Nice_Subarrays().numberOfSubarrays(nums, k));
    }
}
