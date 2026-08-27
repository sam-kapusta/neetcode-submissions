class Solution {
    public int characterReplacement(String s, int k) {

        //Only uppercase so could have int[]
        // Find top value would also be constant
        // Want to check if currMax + k >= end - start + 1
        // end loop update next

        int[] letters = new int[26];
        int start = 0;
        int res = 0;
        for(int i=0; i < s.length(); i++){  
            letters[s.charAt(i) - 'A']++; // increment i
            // get a valid amount if we include current, if not keep moving start forward
            while(getMax(letters) + k < i - start + 1) { 
                letters[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    private int getMax(int[] letters) {
        int max = 0;
        for(int val : letters) max = Math.max(max, val);
        return max;
    }
    
}