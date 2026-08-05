class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(res, subset, 0, nums, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset, int curr, int[] nums, int target, int sum) {
        if(sum == target){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(sum > target || curr == nums.length) return;


        subset.add(nums[curr]);
        dfs(res, subset, curr, nums, target, sum + nums[curr]);
        subset.remove(subset.size()-1);
        dfs(res, subset, curr+1, nums, target, sum);
    }
}
