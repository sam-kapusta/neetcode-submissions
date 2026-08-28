class Solution {
    public int[] topKFrequent(int[] nums, int k) {


        // k most frequent elements in array, 

        // would be good to have a count of how frequently each number shows up
        // We can then organize by values, like how much in like an array and then go downwards from the top


        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] count = new List[nums.length+1];
        for(int key : map.keySet()) {
            if(count[map.get(key)] == null) count[map.get(key)] = new ArrayList<>();
            count[map.get(key)].add(key);
        }

        int[] res = new int[k];
        int j = 0;
        for(int i=count.length-1; i >= 0; i--) {
            if(count[i] == null) continue;
            for(Integer curr : count[i]){
                res[j] = curr;
                j++;
                if(j >= k) return res;
            }
        }
        return res;
    }
}
