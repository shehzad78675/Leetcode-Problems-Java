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
    public void leftMost(TreeNode root, int maxLvl[], int lvl[], int ans[]){
        if(root == null){
            return;
        }

        if(maxLvl[0] < lvl[0]){
            maxLvl[0] = lvl[0];
            ans[0] = root.val;
        }

        lvl[0] += 1;
        leftMost(root.left, maxLvl, lvl, ans);
        leftMost(root.right, maxLvl, lvl, ans);
        lvl[0] -= 1;
    }
    public int findBottomLeftValue(TreeNode root) {
        int[] maxLvl = new int[1];
        int[] lvl = {1};
        int[] ans = new int[1];

        leftMost(root, maxLvl, lvl, ans);
        return ans[0];
    }
}