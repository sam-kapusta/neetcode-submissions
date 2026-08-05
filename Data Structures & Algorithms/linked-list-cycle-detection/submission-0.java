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
    public boolean hasCycle(ListNode head) {

        // return true if cycle in linked list
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != null && fast != null) {
            if(slow.val == fast.val) return true;

            if(fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
