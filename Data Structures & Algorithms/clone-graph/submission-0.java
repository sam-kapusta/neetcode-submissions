/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null) return null;

        HashMap<Integer, Node> seen = new HashMap<>();
        Node copy = new Node(node.val, new ArrayList<Node>());
        seen.put(node.val, copy);
        
        for(Node neighbor : node.neighbors) {
            dfs(neighbor, copy, seen);
        }

        return copy;
    }

    private void dfs(Node neighbor, Node copy, Map<Integer, Node> seen) {

        if(seen.containsKey(neighbor.val)) {
            copy.neighbors.add(seen.get(neighbor.val));
            return;
        }

        Node childCopy = new Node(neighbor.val, new ArrayList<Node>());
        copy.neighbors.add(childCopy);
        seen.put(neighbor.val, childCopy);

        for(Node n : neighbor.neighbors){
            dfs(n, childCopy, seen);
        }
        return;
    }
}