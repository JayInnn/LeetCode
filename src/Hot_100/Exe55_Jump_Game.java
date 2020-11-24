package Hot_100;

public class Exe55_Jump_Game {
    public boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--){
            n = nums[i] >= n ? 1 : n + 1;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(new Exe55_Jump_Game().canJump(nums));
    }
}
