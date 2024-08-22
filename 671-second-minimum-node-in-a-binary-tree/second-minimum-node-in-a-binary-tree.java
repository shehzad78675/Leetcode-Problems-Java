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
    public void minValue(TreeNode root, PriorityQueue max){
        if(root == null){
            return;
        }
        if(!max.contains(root.val)){
            max.add(root.val);
            if(max.size() > 2){
                max.remove();
            }
        }
        minValue(root.left, max);
        minValue(root.right, max);
    }
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        minValue(root, pq);

        if(pq.size() <2){
            return -1;
        }
      
        return pq.remove();
    }
}