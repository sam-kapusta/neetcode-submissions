class Solution {
    public int maxProfit(int[] prices) {
        
        // max profit if u buy one day and sell in the future

        // keep track of current max, 

        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int num : prices) {
            min = Math.min(min, num);
            maxProfit = Math.max(maxProfit, num-min);
        }
        return maxProfit;
    }
}
