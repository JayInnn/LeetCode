package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-10
 */
public class Exe101_Symmetric_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode r1, TreeNode r2){
        if (r1 == null && r2 == null){
            return true;
        }
        if (r1 == null || r2 == null){
            return false;
        }

        return r1.val == r2.val && isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left= new TreeNode(5);

    }
}
