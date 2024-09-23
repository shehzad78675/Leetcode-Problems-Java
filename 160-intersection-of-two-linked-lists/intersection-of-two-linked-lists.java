/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        int lengthA = 0;
        ListNode temp = headA;
        while(temp != null){
            lengthA++;
            temp = temp.next;
        }

        int lengthB = 0;
        temp = headB;
        while(temp != null){
            lengthB++;
            temp = temp.next;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;
        if(lengthA < lengthB){
            int length = lengthB - lengthA;
            tempB = headB;
            while(tempB != null && length != 0){
                tempB = tempB.next;
                length--;
            }
        }

        if(lengthA > lengthB){
            int length = lengthA - lengthB;
            tempA = headA;
            while(tempA != null && length != 0){
                tempA = tempA.next;
                length--;
            }
        }

        while(tempA != null && tempB != null){
            if(tempA == tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}