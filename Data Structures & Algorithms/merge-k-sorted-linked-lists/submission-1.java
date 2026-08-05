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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(true) {
            int position = -1;
            ListNode chosen = null; 
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] == null) {
                    continue;
                } else if(chosen == null || chosen.val > lists[i].val) {
                    chosen = lists[i];
                    position = i;
                } 
            }
            
            if(chosen == null) break;
            curr.next = chosen;
            curr = curr.next;
            lists[position] = lists[position].next;
        }
        return dummy.next;
    }
}
