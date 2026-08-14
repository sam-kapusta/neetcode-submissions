class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // return k most frequent


        // for each number, store that number in an array and then always keep track of top 2 spots

        Map<Integer, Integer> vals = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            vals.put(nums[i], vals.getOrDefault(nums[i], 0) + 1);
        }


        List<Integer>[] buckets = new List[nums.length +1];
        for(Integer val : vals.keySet()) {
            int count = vals.get(val);
            if (buckets[count] == null) buckets[count] = new ArrayList<>();
            buckets[count].add(val);
        }


        int[] res = new int[k];
        int curr = 0;
        for(int i=nums.length; i > 0; i--) {
            if(buckets[i] == null) continue;
            for(Integer j : buckets[i]) {
                res[curr] = j;
                curr++;
                if(curr == k) return res;
            }
        }
        return res;

    }
}
