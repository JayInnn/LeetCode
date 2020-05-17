package Hot_100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : YCKJ2794
 * @since : 2020-05-17
 */
public class Exe287_Find_the_Duplicate_Number {

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public int findDuplicateOptimize(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        int ptr1 = nums[0];
        int ptr2 = slow;
        while (ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

}
