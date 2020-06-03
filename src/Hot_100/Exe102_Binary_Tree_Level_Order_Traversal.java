package Hot_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : YCKJ2794
 * @since : 2020-06-03
 */
public class Exe102_Binary_Tree_Level_Order_Traversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 1; i <= size; i++){
                TreeNode temp = queue.poll();
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
                list.add(temp.val);
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left= new TreeNode(15);
        t1.right.right= new TreeNode(7);
        System.out.println(new Exe102_Binary_Tree_Level_Order_Traversal().levelOrder(t1));
    }
}
