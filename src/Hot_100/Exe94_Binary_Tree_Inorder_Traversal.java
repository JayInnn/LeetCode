package Hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YCKJ2794
 * @since : 2020-05-11
 */
public class Exe94_Binary_Tree_Inorder_Traversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list){
        if (root != null) {
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }

}
