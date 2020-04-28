package Hot_100;

import java.util.HashMap;


/**
 * @author : YCKJ2794
 * @since : 2020-04-28
 */
public class Exe169_Majority_Element {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for (int k : nums){
            if (map.containsKey(k)){
                int v = map.get(k) + 1;
                if (v > nums.length / 2){
                    return k;
                }
                map.put(k, v);
            }else {
                map.put(k, 1);
            }
        }
        return nums[0];
    }

    public int majorityElement_Boyer_Moore (int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int i : nums){
            if (count == 0){
                candidate = i;
            }
            count += (candidate == i) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args){

    }
}
