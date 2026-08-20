class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // anagram would have all the same characters just in diff order
        Map<String, List<String>> res = new HashMap<>();

        for(String str : strs) {
            anagram(str, res);
        }

        return new ArrayList<>(res.values()); 
    }


    private void anagram(String str, Map<String, List<String>> res) {
        
        // convert to alphabetical, sort
        // count up all the occurences of letter, int[] -> string
        int[] y = new int[26];

        for(Character c : str.toCharArray()) {
            y[c - 'a']++;
        }

        String key = Arrays.toString(y); // "[3, 0, 1, 2, 3, ...]"

        res.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
}
