class Solution {
    public int[] productExceptSelf(int[] nums) {

        // array output where it's product of everything excep itself
        // O(n) time

        // -- Go from left and keep a multiplier 

        // 1 1 2 8

        int[] res = new int[nums.length];
        res[0] = 1;
        int left = 1;
        for(int i =1; i < nums.length; i++) {
            left *= nums[i-1];
            res[i] = left;
        }

        int right = 1;
        for(int i=nums.length-2; i >= 0; i--) {
            right *= nums[i+1];
            res[i] *= right;
        }
        return res;
    }
}  
