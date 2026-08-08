class Solution {
    public int rob(int[] nums) {

        //cant rob two adjacent houses
        Map<Integer, Integer> explored = new HashMap<>();
        return dp(nums, explored, 0);

    }

    private int dp(int[] nums, Map<Integer, Integer> explored, int i) {

        if(i >= nums.length) return 0;
        if(explored.containsKey(i)) return explored.get(i);


        int skip = dp(nums, explored, i+1);
        int take = nums[i] + dp(nums, explored, i+2);

        explored.put(i, Math.max(skip, take));

        return explored.get(i);


    }
}
