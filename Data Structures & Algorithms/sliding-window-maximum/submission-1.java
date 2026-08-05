class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] output = new int[nums.length - k + 1];
        int l = 0, r = 0;

        while (r < nums.length) {
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast(); // remove all values smaller then new value
            }
            q.addLast(r);

            if(l > q.getFirst()){
                q.removeFirst(); // remove value if not in window anymore
            }

            if((r+1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}
