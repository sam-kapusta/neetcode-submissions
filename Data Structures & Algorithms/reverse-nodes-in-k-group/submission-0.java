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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while(curr != null){
            ListNode start = curr;
            int count = 0;
            for(int i = 0; i < k; i++) {
                if(curr == null) break;
                curr = curr.next;
                count++;
            }

            if(count == k) {
                ListNode newStart = reverse(start, curr);
                prevGroupEnd.next = newStart;
                start.next = curr;
                prevGroupEnd = start;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != tail) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;        
    }
}
