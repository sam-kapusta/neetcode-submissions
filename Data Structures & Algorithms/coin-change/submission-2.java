class Solution {
    public int coinChange(int[] coins, int amount) {

        if(amount < 1) return 0;


        // either take this coin and stay at this level or go one up and dont take coin

        int[] memo = new int[amount+1];
        Arrays.fill(memo, -1);

        int res = dp(coins, amount, memo);
        return res > amount ? -1: res;
        
    }

    private int dp(int[] coins, int amount, int[] memo) {
        if(amount == 0) return 0;
        if(memo[amount] != -1) return memo[amount];

        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(coin <= amount) {
                int res = dp(coins, amount - coin, memo);
                if(res != Integer.MAX_VALUE){
                    min = Math.min(min, 1+ res);
                }
            }
        }

        memo[amount] = min;
        return min;

    }
}
