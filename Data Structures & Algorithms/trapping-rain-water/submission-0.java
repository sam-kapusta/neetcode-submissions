class Solution {
    public int trap(int[] height) {
        
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        int res = 0;

        int max = 0;
        for(int i=0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            prefix[i] = max;        
        }
        max = 0;
        for(int i =height.length-1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            suffix[i]  = max;
        }

        for(int i =0; i < height.length; i++) {
            int curr = Math.min(prefix[i], suffix[i]) - height[i];
            res += curr;
        }
        return res;
    }
}
