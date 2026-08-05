class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(res, subset, 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset, int curr, int[] nums) {
        if(curr >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[curr]);
        dfs(res, subset, curr+1, nums);
        subset.remove(subset.size()-1);
        dfs(res, subset, curr+1, nums);
    } 

}
