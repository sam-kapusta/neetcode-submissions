class Solution {
    public int maxArea(int[] heights) {

        // heights[i] is height of i bar


        // l = 0, r = heights.length-1

        int l = 0;
        int r = heights.length-1;

        int max = 0;
        while(l < r) {
            int width = Math.min(heights[l], heights[r]);
            int curr = (r - l) * width;
            max = Math.max(max, curr);

            if(heights[l] > heights[r]){
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
