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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = dummy;
        ListNode prevNode = null;
        int i=0;
        while(i < left){
            prevNode = temp;
            temp = temp.next;
            i++;
        }

        ListNode curr = temp;
        ListNode prev = prevNode;

        while(i <= right){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        prevNode.next = prev;
        temp.next = curr;

        return dummy.next; 
    }
}