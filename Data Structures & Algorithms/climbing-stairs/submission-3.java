class Solution {
    public int climbStairs(int n) {
        return dfs(n, new HashMap<>());        
    }

    private int dfs(int n, HashMap<Integer, Integer> visited){
        if(visited.containsKey(n)) return visited.get(n);
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }

        int count = dfs(n-1, visited) + dfs(n-2, visited);
        visited.put(n, count);
        return count;
    };
}
