class Solution {
    public int rob(int[] nums) {
        // same as before but u cant rob first and last houses together. That has to be factored into the dp problem. Maybe just a      boolean. Does mean that we will now have ones where you're on dp(3) but there's two values, did you rob the last house or not. So maybe two lists?
        if(nums.length == 1) return nums[0];

        Map<Integer, Integer> mapLast = new HashMap<>();
        Map<Integer, Integer> mapNoLast = new HashMap<>();

        return Math.max(dp(nums, mapLast, 1, true), dp(nums, mapNoLast, 0, false));


        //
    }

    private int dp(int[] nums, Map<Integer, Integer> map, int i, boolean lastAllowed) {

        if(i >= nums.length) return 0;
        if (map.containsKey(i)) return map.get(i);
        if(i == nums.length - 1) {
            if(lastAllowed) return nums[i];
            return 0;
        }

        int skip = dp(nums, map, i+1, lastAllowed);
        int take = nums[i] + dp(nums, map, i+2, lastAllowed);
        map.put(i, Math.max(skip, take));
        return map.get(i);

    }
}
