class Solution {
    public int evalRPN(String[] tokens) {
        
        // store last two numbers

        Stack<Integer> vals = new Stack<>();
        int res = 0;

        for(int i=0; i < tokens.length; i++) {
            if(tokens[i].charAt(0) == '+') {
                int curr = vals.pop() + vals.pop();
                vals.push(curr);
            }
            else if(tokens[i].charAt(0) == '-' && tokens[i].length() == 1){
                int first = vals.pop();
                int second = vals.pop();
                vals.push(second-first);
            }
            else if(tokens[i].charAt(0) == '*'){
                int curr = vals.pop() * vals.pop();           
                vals.push(curr);
            }
            else if(tokens[i].charAt(0) == '/'){
                int first = vals.pop();
                int second = vals.pop();           
                vals.push(second / first);
            } else {
                vals.push(Integer.parseInt(tokens[i]));
            }
        }
        return vals.pop();
    }
}
