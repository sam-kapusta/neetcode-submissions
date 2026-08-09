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
        HashMap<Integer, Node> vals = new HashMap<>();
        return dfs(node, vals);

    }

    private Node dfs(Node node, Map<Integer, Node> vals) {
        if(vals.containsKey(node.val)) return vals.get(node.val);

        Node copy = new Node(node.val);
        vals.put(node.val, copy);

        for(Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, vals));
        }

        return vals.get(node.val);


    }
}
