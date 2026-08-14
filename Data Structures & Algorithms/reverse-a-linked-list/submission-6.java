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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        return reverse(null, head);


        // prev 0 curr 1
        // temp = 2
        // 1.next = 0
        // reverse (1, 2)
        // (2, 3)
        // 3, null

        
    }

    private ListNode reverse(ListNode prev, ListNode curr) {
        if(curr == null) return prev;
        ListNode temp = curr.next;
        curr.next = prev;
        return reverse(curr, temp);
    }
}
