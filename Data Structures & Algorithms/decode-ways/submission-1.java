class Solution {
    public int numDecodings(String s) {
        

        // number of ways to decode it. 01 is not an option. So any option between 1-26 is possible
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, memo, 0);


    }

    private int dp(String s, int[] memo, int i) {

        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(memo[i] != -1) return memo[i];

        int count = dp(s, memo, i+1);
        if(i+1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(i, i+2));
            if (twoDigit <= 26) {
                count += dp(s, memo, i+2);
            }
        }

        memo[i] = count;
        return count;
    }
}
