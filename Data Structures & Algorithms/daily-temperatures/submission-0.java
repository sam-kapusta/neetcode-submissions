class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        // temperature[i] is daily temperature on the ith day
        

        
        Stack<int[]> stack = new Stack<int[]>();
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);

        for(int i = 0 ; i < temperatures.length; i++) {
            
            // smallest values will be on right side, biggest values on left side
            if(stack.isEmpty()) {
                stack.push(new int[]{temperatures[i], i});
            }

            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] vals = stack.pop();
                res[vals[1]] = i-vals[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
