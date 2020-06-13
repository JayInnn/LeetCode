package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-06-08
 */
public class Exe98_Validate_Binary_Search_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }


    private boolean helper(TreeNode root, Integer lower, Integer upper){
        if (root == null){
            return true;
        }

        int rootVal = root.val;
        if (lower != null && lower >= rootVal){
            return false;
        }

        if (upper != null && upper <= rootVal){
            return false;
        }

        if (! helper(root.left, lower, rootVal)){
            return false;
        }

        if (! helper(root.right, rootVal, upper)){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(5);
        t1.left.left= new TreeNode(0);
        t1.left.right= new TreeNode(2);
        t1.right.left= new TreeNode(4);
        t1.right.right= new TreeNode(6);
        System.out.println(new Exe98_Validate_Binary_Search_Tree().isValidBST(t1));
    }
}
