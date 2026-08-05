class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> vals = new HashSet<Integer>();
        for(int num : nums) {
            vals.add(num);
        }
        int highest_streak = 0;

        for(int num : nums) {
            if(vals.contains(num-1)) continue;
            int streak = 0;
            int curr = num;
            while(vals.contains(curr)){
                curr += 1;
                streak += 1;
            }
            highest_streak = Math.max(highest_streak, streak);
    }
    return highest_streak;
}
}
