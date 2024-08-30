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
    public int getSum(TreeNode root, int[] res){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return (res[0]*10) + root.val;
        }

        
        res[0] = (res[0]*10) + root.val;

        int left = getSum(root.left, res);
        int right = getSum(root.right, res);

        res[0] = res[0]/10;

        return left + right;
    }
    public int sumNumbers(TreeNode root) {
        return getSum(root, new int[]{0});
    }
}