class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> vals = new PriorityQueue<>();
        for(int num : nums) {
            vals.offer(num);
            if(vals.size() > k) {
                vals.poll();
            }
        }
        
        return vals.peek();
        

    }
}
