class Solution {
    public boolean validTree(int n, int[][] edges) {
        // do they make up a valid tree. There's no way to get back to original
        // has a y been reached by two things

        if(edges.length != n-1) return false;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int[] val : edges){
           graph.computeIfAbsent(val[0], k -> new ArrayList()).add(val[1]);
           graph.computeIfAbsent(val[1], k -> new ArrayList()).add(val[0]);
        }
        dfs(graph, 0, visited);
        return visited.size() == n;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int curr, Set<Integer> visited) {
        if(visited.contains(curr)) return;
        visited.add(curr);
        for(Integer val : graph.getOrDefault(curr, List.of())){
            dfs(graph, val, visited);
        }
    }
}
