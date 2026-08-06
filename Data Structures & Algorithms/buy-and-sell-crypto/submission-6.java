class Solution {
    public int maxProfit(int[] prices) {

        // keep track of lowest price at any point and diff bw that price ad curr value

        int low = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(int price : prices){
            if(price < low) {
                low = price;
            }

            maxProfit = Math.max(maxProfit, price - low);
        }

        return maxProfit;        
    }
}
