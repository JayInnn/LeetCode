package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/28
 * @description:
 * @result:
 */
public class Exe27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length <= 0)
            return 0;
        int checked = -1;
        for (int i = 0; i < length; i++)
            if (nums[i] != val){
                nums[++checked] = nums[i];
            }
        return checked + 1;
    }
}
