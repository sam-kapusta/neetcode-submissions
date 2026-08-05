class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // group all anagrams together into sublists
        // key should be alphanumeric order. It can even just be represented as char array, Or as char array to string. 


        // 1: create hashmap where key is char[] alphanumeric, values are all the items in it. 
        // 1.5: private function that does the alphanumeric conversion
        // 2: loop through all the values of hashmap, save into arraylist

        Map<String, List<String>> vals = new HashMap<>();
        for(String str : strs) {
            String converted = alphaNumericRep(str);
            vals.putIfAbsent(converted, new ArrayList<>());
            vals.get(converted).add(str);
        }
        return new ArrayList<>(vals.values());
    }

    private String alphaNumericRep(String val) {
        int[] charCount = new int[26];
        for(Character c : val.toCharArray()) {
            charCount[c-'a']++;
        }
        return Arrays.toString(charCount);
    }
}
