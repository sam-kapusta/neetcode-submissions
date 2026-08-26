class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Find length of longest substring without duplicate characters

        // keep track of longest u have seen so far maybe with a hashset bc only ever one. if character equals the value u want remove from hashset and from list. That way u always have list of unique characters

        HashSet<Character> seen = new HashSet<Character>();
        int start = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) { 
            while(seen.contains(s.charAt(i))) {
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(s.charAt(i));
            max = Math.max(max, i - start + 1);
        }
        return max;
        
    }
}
