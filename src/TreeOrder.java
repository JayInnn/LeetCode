import java.util.LinkedList;

/**
 * @author : YCKJ2794
 * @since : 2020-06-17
 */
public class TreeOrder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /*
     ** 递归实现
     */
    private void preOrderRecursion(TreeNode root){
        if (root != null){
            System.out.println(root.val);
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }
    }

    private void inOrderRecursion(TreeNode root){
        if (root != null){
            inOrderRecursion(root.left);
            System.out.println(root.val);
            inOrderRecursion(root.right);
        }
    }

    private void postOrderRecursion(TreeNode root){
        if (root != null){
            postOrderRecursion(root.left);
            postOrderRecursion(root.right);
            System.out.println(root.val);
        }
    }

    /*
    ** 迭代实现
     */
    private void preOrderIterator(TreeNode root){
        if (root == null){
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (! stack.isEmpty()){
            TreeNode tmp = stack.pop();
            System.out.println(tmp.val);
            if (tmp.right != null){
                stack.push(tmp.right);
            }
            if (tmp.left != null){
                stack.push(tmp.left);
            }
        }
    }

    private void inOrderIterator(TreeNode root){
        if (root == null){
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode tmp = root;

        while (tmp != null){
            stack.push(tmp);
            if ((tmp = tmp.left) == null){
                while (! stack.isEmpty()){
                    tmp = stack.pop();
                    System.out.println(tmp.val);
                    if (tmp.right != null){
                        tmp = tmp.right;
                        break;
                    }
                }
            }
        }
    }

    private void postOrderIterator(TreeNode root){
        if (root == null){
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        stack.push(root);

        while (! stack.isEmpty()){
            TreeNode tmp = stack.pop();
            output.addFirst(tmp.val);

            if (tmp.left != null){
                stack.push(tmp.left);
            }

            if (tmp.right != null){
                stack.push(tmp.right);
            }
        }
        output.forEach(System.out::println);
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(5);
        t1.left.left= new TreeNode(0);
        t1.left.right= new TreeNode(2);
        t1.right.left= new TreeNode(4);
        t1.right.right= new TreeNode(6);
        System.out.println();
    }
}
