package Chapter1;

import java.util.HashMap;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/14
 * @description:
 * @result:
 */
public class Exe01_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        int size = (new Double(nums.length / 0.75)).intValue();
        HashMap<Integer, Integer> hashMap = new HashMap<>(size);
        for (int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(nums[i])){
                index[0] = i;
                index[1] = hashMap.get(nums[i]);
            }
            hashMap.put(target-nums[i], nums[i]);
        }
        return index;
    }
}
