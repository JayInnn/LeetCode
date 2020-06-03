package Hot_100;

import java.util.Arrays;

/**
 * @author : YCKJ2794
 * @since : 2020-06-03
 */
public class Exe215_Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);

        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int p, int q){
        if (p < q){
            int k = partition(nums, p, q);
            quickSort(nums, p, k - 1);
            quickSort(nums, k + 1, q);
        }
    }

    private int partition(int[] nums, int p, int q){
        int key = nums[q];
        int j = p - 1;
        for (int i = p; i < q; i++){
            if (nums[i] < key){
                j = j + 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[q] = nums[j+1];
        nums[j+1] = key;
        return j + 1;
    }


    public int findKthLargestOptimize(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new Exe215_Kth_Largest_Element_in_an_Array().findKthLargest(nums, k));
    }

}
