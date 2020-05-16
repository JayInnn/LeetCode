package Hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YCKJ2794
 * @since : 2020-05-11
 */
public class Exe114_Flatten_Binary_Tree_to_Linked_List {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int x) {
            val = x;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        List<TreeNode> ans = new ArrayList<>();
        helper(root, ans);
        root.left = null;
        if (ans.size() > 1){
            TreeNode tmp = root;
            for (int i = 1; i < ans.size(); i++){
                tmp.right = ans.get(i);
                tmp.right.left = null;
                tmp = tmp.right;
            }
        }
    }

    private void helper(TreeNode root, List<TreeNode> ans){
        if (root != null){
            ans.add(root);
            helper(root.left, ans);
            helper(root.right, ans);
        }
    }


    public void flattenOptimize(TreeNode root) {
        if (root != null){
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            flattenOptimize(root.right);
            TreeNode tmp = root;
            while (tmp.right != null){
                tmp = tmp.right;
            }
            tmp.right = tempRight;
            flattenOptimize(tempRight);
        }
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(13);
        t1.left.left= new TreeNode(1);
        new Exe114_Flatten_Binary_Tree_to_Linked_List().flatten(t1);
    }
}
