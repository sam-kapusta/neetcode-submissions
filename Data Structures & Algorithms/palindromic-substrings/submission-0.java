class Solution {
    public int countSubstrings(String s) {

        // u can count using dp still, just dont return just max keep updating count
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length()-1; i>= 0; i--) {
            for(int j=i; j < s.length(); j++) {
                
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])) {
                    count++;
                    dp[i][j] = true;
                }

            }
        }
        return count;
        
    }
}
