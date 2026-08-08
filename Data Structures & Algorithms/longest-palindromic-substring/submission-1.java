class Solution {
    public String longestPalindrome(String s) {
        
        // At each character, u need to decide whether to keep going in the palindrone or start doing the stack unwinding. 
        // Like you can decide hey bab next character is b, do we start unwinding stack or add it to stack

        int resLen = 0;
        String res = "";
        for(int i =0; i < s.length(); i++) {
            for(int j=i; j < s.length(); j++) {

                int l=i; 
                int r=j;

                while(l < r && s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }

                if(l >= r && resLen < j - i + 1){
                    String curr = s.substring(i, j+1);
                    res = curr;
                    resLen = curr.length();
                }



            }
        }

        return res;

    }
}
