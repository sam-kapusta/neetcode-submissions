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
        int[] chars = new int[26];
        for(Character c : str.toCharArray()){
            chars[c - 'a']++; 
        }
        return Arrays.toString(chars);
    }

}
