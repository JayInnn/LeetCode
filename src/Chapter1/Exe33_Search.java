package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/29
 * @description:
 * @result:
 */
public class Exe33_Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] < nums[right]){
                if (nums[middle] < target && target <= nums[right])
                    left = middle + 1;
                else
                    right = middle - 1;
            } else{
                if (nums[left] <= target && target < nums[middle])
                    right = middle - 1;
                else
                    left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {3,4,5,6,7,0,1,2};
        System.out.println(new Exe33_Search().search(nums, 8));
    }
}
