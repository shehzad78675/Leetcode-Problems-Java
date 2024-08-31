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
    String listToString(List<Integer> list){
        StringBuilder str = new StringBuilder();
        str.append(list.get(0));
        for(int i=1; i<list.size(); i++){
            str.append("->" + list.get(i));
        }
        return str.toString();
    }
    public void paths(TreeNode root, List<Integer> list, List<String> res){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
            res.add(listToString(list));
            list.remove(list.size()-1);
            return;
        }
        
        list.add(root.val);

        paths(root.left, list, res);
        paths(root.right, list, res);
        
        list.remove(list.size()-1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        paths(root, list, res);
        return res;
    }
}