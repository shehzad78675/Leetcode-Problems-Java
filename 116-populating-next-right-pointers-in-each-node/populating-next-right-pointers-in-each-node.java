/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size() > 1){
            int size = q.size();
            for(int i=0; i < size; i++){
                Node node = q.remove();
                if(node == null){
                    q.add(null);
                    continue;
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }

                node.next = q.peek();
            }
        }
        return root;
    }
}