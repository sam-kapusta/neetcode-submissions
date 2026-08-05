class Solution {
    public int characterReplacement(String s, int k) {
        
        // create a hashset of all characters in string
        // l = 0, r = 0, 

        // if 

        int[] freq = new int[26];
        int maxFreq = 0;
        int l = 0, res = 0;
        for(int r=0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r)-'A']);
        
            if(((r - l + 1) - maxFreq) > k) {
                freq[s.charAt(l)-'A']--;
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
