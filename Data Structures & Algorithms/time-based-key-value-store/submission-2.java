class TimeMap {

    Map<String, List<Pair<Integer,String>>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> pairs = timeMap.getOrDefault(key, new ArrayList<>());
        int l = 0; int r = pairs.size() - 1;
        String res = "";

        while (l <= r){
            int mid = l + (r-l)/2;
            if(pairs.get(mid).getKey() > timestamp) {
                r = mid - 1;
            } else {
                res = pairs.get(mid).getValue();
                l = mid + 1;
            }
        }
        return res;
    }
}
