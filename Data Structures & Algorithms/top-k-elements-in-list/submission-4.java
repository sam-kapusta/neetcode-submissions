class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        List<List<Integer>> freq = new ArrayList();

        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for(int i=0; i <= nums.length; i++) {
            freq.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq.get(entry.getValue()).add(entry.getKey());
        }

        int[] result = new int[k];
        int curr = 0;
        for(int i =nums.length; i >= 0 && curr < k; i--) {
            for(int num : freq.get(i)) {
                result[curr++] = num;
                if(curr == k) return result;
            }
        } 
        return result;   
    }
}
