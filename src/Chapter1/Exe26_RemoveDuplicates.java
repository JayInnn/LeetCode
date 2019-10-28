package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/28
 * @description:
 * @result:
 */
public class Exe26_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 0)
            return 0;
        int checked = 0;
        for (int i = 0; i < length; i++)
            if (nums[i] != nums[checked]){
                nums[++checked] = nums[i];
            }
        return checked + 1;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1};
        System.out.println(new Exe26_RemoveDuplicates().removeDuplicates(nums));
    }
}
