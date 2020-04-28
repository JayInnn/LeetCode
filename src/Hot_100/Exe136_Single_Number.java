package Hot_100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : YCKJ2794
 * @since : 2020-04-28
 */
public class Exe136_Single_Number {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }

    public int singleNumber_math(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        int doubleSum = 0;
        int singleSum = 0;
        for (int i = 0; i < nums.length; i++){
            if (!set.contains(nums[i])){
                set.add(nums[i]);
                singleSum += nums[i];
            }
            doubleSum += nums[i];
        }
        return singleSum * 2 - doubleSum;
    }

    public int singleNumber_idea(int[] nums){
        int i = 0;
        for (int j = 0; j <nums.length; j++){
            i ^= nums[j];
        }
        return i;
    }

    public static void main(String[] args){
        int[] a = {2,2,1};
        System.out.println(new Exe136_Single_Number().singleNumber(a));
    }
}
