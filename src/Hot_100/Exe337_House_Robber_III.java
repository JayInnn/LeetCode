package Hot_100;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/6/26
 * @description:
 * @result:
 */
public class Exe337_House_Robber_III {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int money = root.val;
        if (root.left != null){
            money = money + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null){
            money = money + rob(root.right.left) + rob(root.right.right);
        }
        int left = rob(root.left);
        int right = rob(root.right);
        return Math.max(money, left + right);
    }
}
