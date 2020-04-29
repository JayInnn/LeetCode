package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-04-28
 */
public class Exe538_Convert_BST_to_Greater_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(13);
        t1.left.left= new TreeNode(1);
        System.out.println(new Exe538_Convert_BST_to_Greater_Tree().convertBST(t1));

    }
}
