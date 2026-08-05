class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        // if s2 contains permutation of s1, false otherwise


        int slide = s1.length();

        int l = 0;
        char[] sortedS1 = s1.toCharArray();
        Arrays.sort(sortedS1);

        for(int r=slide-1; r < s2.length(); r++){
            char[] sortedS2 = s2.substring(l,r+1).toCharArray();
            Arrays.sort(sortedS2);

            if(Arrays.equals(sortedS1, sortedS2)) return true;
            l++;
        }
        return false;
    }
}
