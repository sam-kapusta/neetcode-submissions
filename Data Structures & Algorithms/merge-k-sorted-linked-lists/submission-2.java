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

        while(lists.length > 1) {
            ArrayList<ListNode> items = new ArrayList<>();
            for(int i=0;i< lists.length; i+=2) {
                ListNode one = lists[i];
                ListNode two = lists.length > (i+1) ? lists[i+1] : null;
                ListNode res = mergeTwoLists(one, two);
                items.add(res);
            }

            lists = items.toArray(new ListNode[0]);
        }    
    
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode one, ListNode two) {
        if(one == null) return two;
        if(two == null) return one;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(one != null && two != null) {
            if(one.val < two.val) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }
        if(one == null) curr.next = two;
        if(two == null) curr.next = one;

        return dummy.next;

    }
}
