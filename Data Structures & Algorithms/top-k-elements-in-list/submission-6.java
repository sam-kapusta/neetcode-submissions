class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // return k most frequent elements, ideally O(n) time 
        // simple way is keep a hashmap and count everything, and return top 2 highest counts maybe by using a sorting method 
        // O(n log n)


        // could do a count still a hashmap, 2 -> 3 times it occured
        // throw into a second data structure, maybe a List<Integer>[] where each index is the value of # of occurences, and it contains all the numbers that occured that amount
        // search downwards from top, if null avoid, until u hit k

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); 
        }

        List<Integer>[] freq = new List[nums.length+1];

        for(Integer key : map.keySet()) {
            if(freq[map.get(key)] == null) freq[map.get(key)] = new ArrayList<>();
            freq[map.get(key)].add(key);
        }

        int[] res = new int [k];
        int count = 0;

        for(int i=nums.length; i > 0; i--) {
            if(freq[i] == null) continue;
            for(Integer j : freq[i]) {
                res[count++] = j;
                if(count == k) return res;
            }
        }
        return res;
    }
}
