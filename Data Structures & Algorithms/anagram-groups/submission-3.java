class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        // group all anagrams into substrings.
        Map<String, List<String>> map = new HashMap<>();
        for(String curr : strs) {
            findAnagram(curr, map);
        }
        return new ArrayList<>(map.values());

    }

    private void findAnagram(String curr, Map<String, List<String>> map){

        int[] base = new int[26];

        for(char c : curr.toCharArray()) {
            base[c - 'a']++;
        }

        String res = Arrays.toString(base);
        map.computeIfAbsent(res, k -> new ArrayList<>()).add(curr);

    }
}
