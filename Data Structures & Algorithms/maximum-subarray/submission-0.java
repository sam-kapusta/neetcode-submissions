class Solution {
    public int maxSubArray(int[] nums) {

        // find subarray with the largest sum and return sum

        // at each position decide whether to keep or drop the previous one 


        // -1, 2, 3, -1

        // At -1, 2 you can drop the -1
        // At 2,3, u have found max os u can add on the -1 to keep exploring


        int curr=0;
        int max =Integer.MIN_VALUE;;

        for(int i=0; i < nums.length; i++) {
            
            curr = curr + nums[i];
            max = Math.max(curr, max);
            if(curr < 0) curr = 0;
        }
        
        return max;
    }
}
