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
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = l1;
        int carry = 0;
        ListNode prev = null;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            int num = sum%10;
            carry = sum/10;
            l1.val = num;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            int num = sum%10;
            carry = sum/10;
            l1.val = num;
            prev = l1;
            l1 = l1.next;
        }
        l1 = prev;
        while(l2 != null){
            int sum = l2.val + carry;
            int num = sum%10;
            carry = sum/10;
            l2.val = num;
            l1.next = l2;
            l1 = l1.next;
            prev = l1;
            l2 = l2.next;
        }
        l1 = prev;
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            l1.next = newNode;
        }
        return head;
    }
}