class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> items = new HashSet<>();
        for(int i : nums) {
            if(items.contains(i)) return true;
            items.add(i);
        }
        return false;
    }
}
