class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
       Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

       for(String str : strs) {
            String key = getKey(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
       }

       return new ArrayList<>(map.values());

    }

    private String getKey(String str) {
        char[] vals = str.toCharArray();
        Arrays.sort(vals);
        return new String(vals);
    }
}

// 1000010001000010001 -> {tan, nat, ant}

// ant -> {tan, nat, ant}


// aht -> 
// 1000001000000000001000000000