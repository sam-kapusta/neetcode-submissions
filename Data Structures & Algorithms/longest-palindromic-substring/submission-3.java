class Solution {
    public String longestPalindrome(String s) {
        
        // At each character, u need to decide whether to keep going in the palindrone or start doing the stack unwinding. 
        // Like you can decide hey bab next character is b, do we start unwinding stack or add it to stack
        int resLen = 0;
        String res = "";

        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i = s.length()-1; i >= 0; i--){
            for(int j=i; j < s.length(); j++) {
                int l = i;
                int r = j;
                if(s.charAt(l) == s.charAt(r) && (r-l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if(resLen < r-l+1) {
                        resLen = r-l+1;
                        res = s.substring(l, r+1);
                    }
                }
            }
        }
        return res;

    }
}
