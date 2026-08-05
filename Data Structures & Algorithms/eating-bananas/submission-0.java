class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // h = total hours to eat all the bannanas

        // while loop, each loop will be starting from 1 eating rate until 
        // we satisfy the h hours. 

        // upper bound of answer is largest pile

        int lo=1;
        int hi = -1;
        for(int val : piles) hi = Math.max(hi, val);
        int res =hi;

        while(lo <= hi) {
            int mid = lo + (hi-lo) / 2;
            if(checkSpeed(piles, mid, h)) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }

    private boolean checkSpeed(int[] piles, int speed, int h) {
        int total = 0;
        for(int p : piles) {
            total += (p + speed - 1) / speed;
        }
        return total <= h;
    }
}
