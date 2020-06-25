package Hot_100;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/6/25
 * @description:
 * @result:
 */
public class Exe124_Binary_Tree_Maximum_Path_Sum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPath;
    }

    public int maxGain(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxGain(root.left);
        int right = maxGain(root.right);
        int sum = 0;
        if (left > 0 && right > 0){
            sum = Math.max(left, right);
            maxPath = Math.max(maxPath, left + right + root.val);
        }else if (left > 0){
            sum = left;
            maxPath = Math.max(maxPath, left + root.val);
        }else if (right > 0){
            sum = right;
            maxPath = Math.max(maxPath, right + root.val);
        }else {
            maxPath = Math.max(maxPath, root.val);
        }
        return sum + root.val;

        //优化取最大值的办法
//        int leftGain = Math.max(maxGain(root.left), 0);
//        int rightGain = Math.max(maxGain(root.right), 0);
//        int sum = root.val + leftGain + rightGain;
//        maxPath = Math.max(maxPath, sum);
//        return root.val + Math.max(leftGain, rightGain);
    }

}
