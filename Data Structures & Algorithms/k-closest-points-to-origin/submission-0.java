class Solution {
    public int[][] kClosest(int[][] points, int k) {   
        PriorityQueue<int[]> vals = new PriorityQueue<>((a,b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return distB - distA;
        });

        for(int[] point : points) {
            vals.offer(point);
            if(vals.size() > k) {
                vals.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while(!vals.isEmpty()) {
            res[i++] = vals.poll();
        }
        return res;
    }
}
