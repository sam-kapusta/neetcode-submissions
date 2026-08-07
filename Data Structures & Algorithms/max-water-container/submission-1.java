class Solution {
    public int maxArea(int[] heights) {
        // Max amount of water that can be stored. You want to go in on the smaller size because the smaller size is already what's limiting it. If you go in on the other side it wouldn't do anything even if you find something bigger.


        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while(l < r) {
            int wide = r - l;
            int min = Math.min(heights[l], heights[r]);
            max = Math.max(max, wide * min);

            if(heights[l] > heights[r]) {
                max = Math.max(max, wide * heights[r]);
                r--;
            } else {
                max = Math.max(max, wide * heights[l]);
                l++;
            }
        }
        return max;
    }
}
