package Hot_100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : YCKJ2794
 * @since : 2020-05-17
 */
public class Exe105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }

        if (preorder.length == 1){
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);

        Set<Integer> set = new HashSet<>(preorder.length);

        int leftNum;
        for (leftNum = 0; leftNum < inorder.length; leftNum++){
            if (inorder[leftNum] == preorder[0]){
                break;
            }
            set.add(inorder[leftNum]);
        }
        int[] leftInorder = new int[leftNum];
        System.arraycopy(inorder,0, leftInorder, 0, leftNum);

        int rightNum;
        if (leftNum == 0){
            rightNum = 0;
        }else {
            for (rightNum = 1; rightNum < preorder.length; rightNum++){
                if (!set.contains(preorder[rightNum])){
                    break;
                }
            }
            rightNum = rightNum - 1;
        }
        int[] leftPreorder = new int[rightNum];
        System.arraycopy(preorder, 1, leftPreorder, 0, rightNum);

        int[] rightPreorder = new int[preorder.length - rightNum - 1];
        System.arraycopy(preorder, rightNum + 1, rightPreorder, 0, rightPreorder.length);

        int[] rightInorder = new int[inorder.length - leftNum - 1];
        System.arraycopy(inorder, leftNum + 1, rightInorder, 0, rightInorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

    public static void main(String[] args){
//        int[] preorder = {3,9,20,15,7};
//        int[] inorder = {9,3,15,20,7};
        int[] preorder = {1,2,3};
        int[] inorder = {3,2,1};
        TreeNode root = new Exe105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal()
                .buildTree(preorder, inorder);
        System.out.println(root);
    }

}
