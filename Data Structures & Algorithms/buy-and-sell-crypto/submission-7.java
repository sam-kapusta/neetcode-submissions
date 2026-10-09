class Solution {
    public int maxProfit(int[] prices) {
        
        // Single day to buy one, and sell on diff day, bigg diff
        
        // track smallest so far, track max so far

        int min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i : prices) {
            
            min = Integer.min(min, i);

            res = Integer.max(res, i - min);

        }

        return res;

    }
}
