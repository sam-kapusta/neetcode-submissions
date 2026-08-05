class Solution {
    public int lastStoneWeight(int[] stones) {

        // two heaviest stones, so reverse PriorityQueue.

        PriorityQueue<Integer> vals = new PriorityQueue<>((a,b) -> b - a);
        for(int num : stones) {
            vals.offer(num);
        }

        while(vals.size() > 1) {
            int outcome = vals.poll() - vals.poll();
            if(outcome != 0) {
                vals.offer(outcome);
            }
        }

        if(vals.size() == 0) return 0;
        return vals.poll();
    }
}
