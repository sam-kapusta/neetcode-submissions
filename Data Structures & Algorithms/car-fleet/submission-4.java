class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        // Create an ArrayList of int[], sorted on 0 element

        // PriorityQueue

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        for(int i=0; i < position.length; i++) {
            maxHeap.add(new int[]{position[i], speed[i]});
        }

        Stack<Double> stack = new Stack<Double>();

        while(!maxHeap.isEmpty()) {
            int[] vals = maxHeap.poll();
            double arrivalTime = (target - vals[0]) / (double)vals[1];  

            if(stack.isEmpty() || arrivalTime > stack.peek()) {
                stack.push(arrivalTime);
            }
        }
        return stack.size();
    }
}
