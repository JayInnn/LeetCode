package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-04-26
 */
public class Exe617_Merge_Two_Binary_Trees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 第一次思路：递归，但是没有考虑直接copy子树的情况
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode first_mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null){
            return t1 == null ? t2 : t1;
        }
        TreeNode reult = mergeNode(t1, t2, new TreeNode(-1));
        return reult;
    }

    private TreeNode mergeNode(TreeNode s1, TreeNode s2, TreeNode target){
        if (s1 == null && s2 == null){
            return null;
        }
        int val1 = s1 == null ? 0 : s1.val;
        int val2 = s2 == null ? 0 : s2.val;
        target.val = val1 + val2 ;
        target.left = mergeNode(s1 == null ? null : s1.left, s2 == null ? null : s2.left, new TreeNode(-1));
        target.right = mergeNode(s1 == null ? null : s1.right, s2 == null ? null : s2.right, new TreeNode(-1));
        return target;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left= new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        TreeNode result = new Exe617_Merge_Two_Binary_Trees().mergeTrees(t1, t2);
        System.out.println(result);
    }
}
