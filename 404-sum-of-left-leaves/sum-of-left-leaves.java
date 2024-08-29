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
    public void leftSum(TreeNode root, boolean isLeft, int[] sum){
        if(root == null){
            return;
        }

        if(isLeft && root.left == null && root.right == null){
            sum[0] += root.val;
        }
        leftSum(root.left, true, sum);
        leftSum(root.right, false, sum);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int sum[] = new int[1];
        leftSum(root, false, sum);
        return sum[0];
    }
}