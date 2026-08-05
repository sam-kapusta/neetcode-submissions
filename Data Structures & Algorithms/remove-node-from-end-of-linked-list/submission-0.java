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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null) return head;
        // Get total size of list
        // Subtract total size - n, traverse that for 

        ListNode curr = head;
        int m = 0;
        while(curr != null) {
            curr = curr.next;
            m++;
        }

        // we want to remove the head
        if (m == n) {
            return head.next;
        }

        curr = head;
        int l = m-n;
        for(int i = 1; i < l; i++) {
            curr = curr.next;
        }

        ListNode removing = curr.next;
        ListNode temp = removing.next;
        curr.next = temp;
        return head;
    }
}
