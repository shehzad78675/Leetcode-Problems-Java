/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        ListNode temp = newNode;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        while(temp != null){
           
            if(temp.next != null && set.contains(temp.next.val)){
                temp.next  = temp.next.next;
            }else{
                temp = temp.next;
            }
            
        }
        return newNode.next;
    }
}