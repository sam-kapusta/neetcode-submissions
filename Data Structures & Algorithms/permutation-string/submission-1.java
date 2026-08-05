class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for(int i=0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        int l = 0;
        for(int r=s1.length(); r < s2.length(); r++) {
            if(Arrays.equals(s1Map, s2Map)) return true;

            s2Map[s2.charAt(r)-'a']++;
            s2Map[s2.charAt(l)-'a']--;
            l++;
        }

        return Arrays.equals(s1Map, s2Map);




    }
}
