package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-10
 */
public class Exe543_Diameter_of_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private Integer diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int rootDiameter = depth(root.left) + depth(root.right) + 1;
        return Math.max(diameter, rootDiameter) - 1;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth =depth(root.right);
        diameter = Math.max(diameter, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left= new TreeNode(5);

    }
}
