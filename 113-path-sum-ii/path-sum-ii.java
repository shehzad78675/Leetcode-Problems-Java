/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void paths(TreeNode root, int target, List<Integer> list, List<List<Integer>> res){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null && root.val == target){
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        paths(root.left, target-root.val, list, res);
        paths(root.right, target-root.val, list, res);

        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        
        paths(root, targetSum, new ArrayList<>(), res);
        return res;
    }
}