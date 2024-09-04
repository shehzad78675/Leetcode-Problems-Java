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
    public TreeNode build(int[] pre, int max, int[] ind){
        if(ind[0] == pre.length || pre[ind[0]] > max){
            return null;
        }

        TreeNode root = new TreeNode(pre[ind[0]++]);

        root.left = build(pre, root.val, ind);
        root.right = build(pre, max, ind);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE, new int[]{0});
    }
}