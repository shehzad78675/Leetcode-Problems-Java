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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int length = 1;
        ListNode temp = head;
        while(temp.next != null){
            length++;
            temp = temp.next;
        }

        int rotation = k % length;
        int skip = length - rotation;
        temp.next = head;
        ListNode newLast = head;
        for(int i=1; i<skip; i++){
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
        return head;

        // for(int )
        // while(pos < 0){
        //     pos = -1*pos;
        //     pos = length-pos;
        // }
       
        // temp = head;
        // int count = 0;
        // while(temp != null && pos-1 != count){
        //     count++;
        //     temp = temp.next;
        // }
        // if(temp == null || temp.next == null){
        //     return head;
        // }

        // ListNode newHead = temp.next;
        // temp.next = null;
        // temp = newHead;
        // while(temp.next != null){
        //     temp = temp.next;
        // }
        // temp.next = head;
        // return newHead;
    }
}
