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
    public void solve(TreeNode root, int lvl, List<Integer> ans){
        if(root == null){
            return;
        }
        if(lvl == ans.size()){
            ans.add(root.val);
        }else{
            ans.set(lvl, root.val);
        }
        solve(root.left, lvl+1, ans);
        solve(root.right, lvl+1, ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        solve(root, 0, ans);
        return ans;
    }
}