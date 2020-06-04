package Hot_100;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : YCKJ2794
 * @since : 2020-06-04
 */
public class Exe236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor_First(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        List<TreeNode> pAncestor = nodeAncestor(root, p);

        List<TreeNode> qAncestor = nodeAncestor(root, q);

        for (TreeNode pNode : pAncestor){
            for (TreeNode qNode : qAncestor){
                if (pNode == qNode){
                    return pNode;
                }
            }
        }

        return null;
    }

    private List<TreeNode> nodeAncestor(TreeNode root, TreeNode node){
        if (root == node){
            List<TreeNode> list = new LinkedList<>();
            list.add(root);
            return list;
        }

        if (root == null){
            return null;
        }

        List<TreeNode> leftList = nodeAncestor(root.left, node);
        List<TreeNode> rightList = nodeAncestor(root.right, node);

        List<TreeNode> ans = new LinkedList<>();
        if (leftList != null){
            ans.addAll(leftList);
            ans.add(root);
        }

        if (rightList != null){
            ans.addAll(rightList);
            ans.add(root);
        }

        return ans.size() > 0 ? ans : null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        if (root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }



    public static void main(String[] args){
        TreeNode t1 = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        t1.left = p;
        t1.right = new TreeNode(1);

        t1.left.left = new TreeNode(6);
        t1.left.right = new TreeNode(2);

        t1.right.left= new TreeNode(0);
        t1.right.right= new TreeNode(8);

        t1.left.right.left = new TreeNode(7);

        TreeNode q = new TreeNode(4);
        t1.left.right.right = q;

        System.out.println(new Exe236_Lowest_Common_Ancestor_of_a_Binary_Tree().lowestCommonAncestor(t1, p, q));
    }
}
