class Solution {
    public String minWindow(String s, String t) {
        int have = 0;

        Map<Character, Integer> tChars = new HashMap<Character, Integer>();


        for(int i=0; i < t.length(); i++) {
            tChars.put(t.charAt(i), tChars.getOrDefault(t.charAt(i), 0) + 1);
        }
        int need = tChars.size();


        Map<Character, Integer> window = new HashMap<Character, Integer>();
        int[] res = new int[]{-1,-1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for(int r=0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0) + 1);

            if(tChars.containsKey(c) && window.get(c).equals(tChars.get(c))){
                have++;
            }
            
            while(need == have) {
                if((r-l+1) < resLen){
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                } 
                char d = s.charAt(l);
                window.put(d, window.get(d)-1);
                if(tChars.containsKey(d) && tChars.get(d) > window.get(d)){
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
