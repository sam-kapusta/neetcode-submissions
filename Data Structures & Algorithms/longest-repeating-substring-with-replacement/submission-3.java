class Solution {
    public int characterReplacement(String s, int k) {

        // Choose up to k characters and replace with any other uppercase English character
        // After at most k replacements, return length of longest substring with only one distinct character


        // Keep track of of how many distinct you have at any one point. So XYYX is 2 distinct keys X=2, Y=2. Maybe u can keep track of 
        // largest value of any one and then subtract from k and if too small slide window to the right

        // So you would need to use a PriorityQueue, I forget details around it but top occurences always at top and then u would do top + k and do that with Math.max and take whatever you can get


        int[] count = new int[26];
        int res = 0;
        int start = 0;
        for(int i=0; i < s.length(); i++) {

            count[s.charAt(i) - 'A']++;
            

            while(true){
                int max = 0;
                for(int j : count) max = Math.max(max, j);
                if (((i - start + 1) - max ) <= k) break;
                count[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
