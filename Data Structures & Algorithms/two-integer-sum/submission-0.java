class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> match = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int k = target-nums[i];
            if(match.containsKey(k)) {
                return new int[]{match.get(k), i};
            }
            match.put(nums[i], i);
        }
        return null;
    }
}
