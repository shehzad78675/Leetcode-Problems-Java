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
 class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ans = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));

        while(!q.isEmpty()){

            int min = q.peek().num;
            int first = 0; 
            int last = 0;
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair p = q.remove();
                TreeNode node = p.node;
                int num = p.num;
                int currId = num - min;

                if(i==0) first = currId;
                if(i==size-1) last = currId;
                if(node.left != null){
                    q.add(new Pair(node.left, currId*2+1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, currId*2+2));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}