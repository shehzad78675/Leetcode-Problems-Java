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
    public void paths(TreeNode root, String str, List<String> res){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res.add(str + root.val);
            return;
        }
        
        paths(root.left, str + root.val + "->", res);
        paths(root.right, str + root.val + "->", res);

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        paths(root, "", res);
        return res;
    }
}