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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean isReverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> inList = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();
                inList.add(node.val);
                    
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            if(!isReverse){
                ans.add(inList);
            }else{
                Collections.reverse(inList);
                ans.add(inList);
            }
            isReverse = isReverse == true ? false : true;
        }
        return ans;
    }
}