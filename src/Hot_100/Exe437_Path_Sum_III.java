package Hot_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : YCKJ2794
 * @since : 2020-05-06
 */
public class Exe437_Path_Sum_III {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 双递归，但是存在重复计算子树的路径值，时间复杂度为2^N
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode root, int sum){
        if (root == null){
            return 0;
        }
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + helper(root.left, sum) + helper(root.right, sum);
    }

    /**
     * 优化的想法是通过记录子树的路径减少双重递归的重复计数，
     * 但是由于重复节点无法处理的问题，优化失败，后续重新修改
     */
//    public int pathSumOptimize(TreeNode root, int sum){
//        Map<Integer, Integer> map = pathMap(root);
//        if (map == null || map.size() == 0){
//            return 0;
//        }
//        return map.getOrDefault(sum, 0);
//    }
//
//    private Map<Integer, Integer> pathMap(TreeNode root){
//        if (root != null){
//            Map<Integer, Integer> map = new HashMap<>();
//            Map<Integer, Integer> leftMap = pathMap(root.left);
//            if (leftMap != null){
//                leftMap.forEach((k,v) -> {
//                    if (map.containsKey(k)){
//                        map.put(k, map.get(k) + v);
//                    }else {
//                        map.put(k,v);
//                    }
//                    if (map.containsKey(k + root.val)){
//                        map.put(k+root.val, map.get(k+root.val)+v);
//                    }else {
//                        map.put(k + root.val, v);
//                    }
//                });
//            }
//
//            Map<Integer, Integer> rightMap = pathMap(root.right);
//            if (rightMap != null){
//                rightMap.forEach((k,v) -> {
//                    if (map.containsKey(k)){
//                        map.put(k, map.get(k) + v);
//                    }else {
//                        map.put(k,v);
//                    }
//                    if (map.containsKey(k + root.val)){
//                        map.put(k+root.val, map.get(k+root.val)+v);
//                    }else {
//                        map.put(k + root.val, v);
//                    }
//                });
//            }
//            if (map.containsKey(root.val)){
//                map.put(root.val, map.get(root.val) + 1);
//            }else {
//                map.put(root.val, 1);
//            }
//            return map;
//        }
//        return null;
//    }


    public static void main(String[] args){
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(-3);
        t1.left.left= new TreeNode(3);
        t1.left.right= new TreeNode(2);
        t1.right.right= new TreeNode(11);
        t1.left.left.left= new TreeNode(3);
        t1.left.left.right= new TreeNode(-2);
        t1.left.right.right= new TreeNode(1);
//        System.out.println(new Exe437_Path_Sum_III().pathSumOptimize(t1, 8));

        System.out.println(new Exe437_Path_Sum_III().pathSum(t1, 8));
    }

}
