package Hot_100;

public class Exe300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] maxLength = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] < nums[j]){
                    maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
                }
            }
            ans = Math.max(ans, maxLength[i]);
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,3,2,3};
        new Exe300_Longest_Increasing_Subsequence().lengthOfLIS(a);
    }
}
