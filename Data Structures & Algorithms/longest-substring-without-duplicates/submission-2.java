class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int l = 0, r = 0;
        int max = 0, curr = 0;
        HashMap<Character, Integer> seen = new HashMap<>();

        while(r < s.length()) {
            if(!seen.containsKey(s.charAt(r))) {
                seen.put(s.charAt(r), r);
            } else {
                System.out.println("Here");
                l = Math.max(l, seen.get(s.charAt(r)) + 1);
                seen.put(s.charAt(r), r);
            }
            System.out.println("L, R, char: " + l + " " + r + " " + s.charAt(r));
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
