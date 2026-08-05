class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        if(nums.length == 1){
            return new int[]{1};
        }

        int[] leftPass = new int[nums.length];
        int[] rightPass = new int[nums.length];
        int[] res = new int[nums.length];

        int leftSum =  1;
        for(int i = 0; i < nums.length; i++) {
            leftPass[i] = leftSum * nums[i];
            leftSum = leftPass[i];
        }

        int rightSum =  1;
        for(int i = nums.length-1; i >= 0; i--) {
            rightPass[i] = rightSum * nums[i];
            rightSum = rightPass[i];
        }

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                res[i] = rightPass[i+1];
                continue;
            }
            else if(i==nums.length-1) {
                res[i] = leftPass[i-1];
                continue;
            }
            res[i] = leftPass[i-1] * rightPass[i+1];
        }
        return res;
    }
}  
