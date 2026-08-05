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
