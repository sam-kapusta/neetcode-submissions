class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = 1;
        int currMin = 1;


        for(int num : nums) {

            int tmp = currMax * num;

            currMax = Math.max(Math.max(num * currMax, num* currMin), num);
            currMin = Math.min(Math.min(tmp, num * currMin), num);
            res = Math.max(currMax, res);
    
        }
        return res;


        
    }
}
