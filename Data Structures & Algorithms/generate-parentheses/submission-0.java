class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> results = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        dfs(0,0, n, str, results);
        return results;
    }

    void dfs(int open, int close, int n, StringBuilder str, List<String> results) {
        if(str.length() == n*2) {
            results.add(str.toString());
        }
        if(open < n) {
            str.append("(");
            dfs(open+1, close, n, str, results);
            str.deleteCharAt(str.length()-1);
        }

        if(close < open) {
            str.append(")");
            dfs(open, close+1, n, str, results);
            str.deleteCharAt(str.length()-1);
        }
    }
}
