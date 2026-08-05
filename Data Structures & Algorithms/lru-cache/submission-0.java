class LRUCache {
    private final Map<Integer, Integer> cache;
    private final int capacity;
    // key is used if get or put is called on it
    // O(1) avg

    // Priority Queue 
    // lowest values 


    // hashmap of values
    // queue of when stuff happened
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        // 
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
