class Node {
    int key;
    int value;

    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> vals = new HashMap<Integer, Node>();
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node(-1, -1);
        this.right = new Node(-1,-1);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void delete(Node node) {
        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if(!vals.containsKey(key)) return -1;

        Node curr = this.vals.get(key);
        delete(curr);
        insert(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(vals.containsKey(key)) {
            delete(vals.get(key));
            vals.remove(key);
        }
        Node newNode = new Node(key, value);
        vals.put(key, newNode);
        insert(newNode);

        if(vals.size() > capacity) {
            Node lru = left.next;
            delete(lru);
            vals.remove(lru.key);
        }
    }
}
