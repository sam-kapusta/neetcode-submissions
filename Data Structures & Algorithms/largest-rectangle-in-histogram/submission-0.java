class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<int[]> stack = new Stack<int[]>();
        int maxArea = -1;

        for(int i=0; i < heights.length; i++) {
            if(!stack.isEmpty() && heights[i] < stack.peek()[0]) {
                int idx = i;
                while(!stack.isEmpty() && heights[i] < stack.peek()[0]) {
                    int[] top = stack.pop();
                    maxArea = Math.max(maxArea, top[0] * (i-top[1]));
                    idx = top[1];
                }
                stack.push(new int[]{heights[i], idx});
            } else {
                stack.push(new int[]{heights[i], i});
            }
        }

        while(!stack.isEmpty()){
            int[] top = stack.pop();
            maxArea = Math.max(maxArea, top[0] * (heights.length-top[1]));
        }
        return maxArea;
    }
}
