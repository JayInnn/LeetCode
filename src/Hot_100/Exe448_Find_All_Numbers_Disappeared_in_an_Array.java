package Hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YCKJ2794
 * @since : 2020-04-29
 */
public class Exe448_Find_All_Numbers_Disappeared_in_an_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++){
            if (nums[j] > 0){
                result.add(j + 1);
            }
        }
        return result;
    }

    public static void main(String[] args){

    }

}
