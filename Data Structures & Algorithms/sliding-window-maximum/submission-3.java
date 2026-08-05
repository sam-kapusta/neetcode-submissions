class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    
        // max heap (Priority Queue)

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[] res = new int[nums.length - k + 1];

        int idx = 0;
        for(int i=0; i < nums.length; i++) {
            heap.offer(new int[]{nums[i], i});
            if(i >= k - 1) {
                while(heap.peek()[1] <= (i - k)) { // index 3, k is 3, 3-3-1
                    heap.poll();
                }
                res[idx++] = heap.peek()[0];
            }   
        }
        return res;
    }
}
