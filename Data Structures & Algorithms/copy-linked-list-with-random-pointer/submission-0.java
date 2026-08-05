/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        HashMap<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val); // new head of second list we return
        map.put(head, newHead);

        Node curr = head;
        Node copy = newHead;

        while(curr != null){
            // Add next
            if(curr.next != null) {
                if(!map.containsKey(curr.next)) {
                    map.put(curr.next, new Node(curr.next.val));
                } 
                copy.next = map.get(curr.next);
            }

            if(curr.random != null) {
                if(!map.containsKey(curr.random)) {
                    map.put(curr.random, new Node(curr.random.val));
                }
                copy.random = map.get(curr.random);
            }
            curr = curr.next;
            copy = copy.next;
        }
        return newHead;
    }
}
