package Hot_100;

import java.util.Arrays;

/**
 * @author : YCKJ2794
 * @since : 2020-04-29
 */
public class Exe283_Move_Zeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2){
            return;
        }
        int firstZero = -1;
        for (int j = 0; j < nums.length; j++){
            if (nums[j] == 0 && firstZero == -1){
                firstZero = j;
                continue;
            }
            if (nums[j] != 0 && firstZero != -1){
                nums[firstZero] = nums[j];
                nums[j] = 0;
                firstZero++;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        new Exe283_Move_Zeroes().moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
