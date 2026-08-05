class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        for(int i =0; i < nums.length; i++) {
            int l = i+1, r = nums.length-1;
            while(l < r) {
                int val = nums[i] + nums[l] + nums[r];
                if(val == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (val < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
