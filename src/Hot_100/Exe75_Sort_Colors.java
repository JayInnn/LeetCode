package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-06-13
 */
public class Exe75_Sort_Colors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int zeroEnd = -1, oneEnd = -1;
        int length = nums.length;
        for (int i = 0; i < length; i++){
            if (nums[i] == 0){
                zeroEnd++;
                oneEnd++;
                swap(nums, i, zeroEnd);
                if (oneEnd != i && oneEnd != zeroEnd){
                    swap(nums,i, oneEnd);
                }
            }else if (nums[i] == 1){
                oneEnd++;
                swap(nums, i, oneEnd);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args){
        int[] nums = {1,0};
        new Exe75_Sort_Colors().sortColors(nums);
        System.out.println(nums);
    }


}
