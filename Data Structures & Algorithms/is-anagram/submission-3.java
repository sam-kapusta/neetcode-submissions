class Solution {
    public boolean isAnagram(String s, String t) {

        // true if anagrams of each other, false otherwise
        if(s.length() != t.length()) return false;
        int[] vals = new int[26];

        for(int i = 0; i < s.length(); i++) {
            vals[s.charAt(i)-'a'] += 1;
            vals[t.charAt(i)-'a'] -= 1;
        }

        for(int val : vals) {
            if(val != 0) return false;
        }
        return true;
    }
}
