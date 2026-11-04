class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] vals = new int[26];
        for(char c : s.toCharArray()) {
            vals[Character.toLowerCase(c) - 'a']++;
        }

        for(char c : t.toCharArray()) {
            if(--vals[Character.toLowerCase(c) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}

// If two strings are of different lengths they cannot be anagrams. Make an array counting all 26 leters, for every character in s append. Now loop through t and subtract, if you get below 0, return false because not possible to be an anagram. 
