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
    public void reorderList(ListNode head) {

        // find length of list
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        // find start of second list
        int half = (count+1)/2;
        ListNode list1 = head;
        ListNode list2 = head;
        while(half > 0) {
            half--;
            curr = list2;
            list2 = list2.next;
        }
        curr.next = null;

        // reverse list
        ListNode prev = null;
        while(list2 != null) {
            ListNode temp = list2.next;
            list2.next = prev;
            prev = list2;
            list2 = temp;
        }
        list2 = prev;

        // merge lists
        list1 = head;
        while(list1 != null && list2 != null) {
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;    

            list1.next = list2;
            list2.next = temp1;

            list1 = temp1;
            list2 = temp2;
        }
    }
}