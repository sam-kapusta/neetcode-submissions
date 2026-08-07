class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //* you're moving through it, need to keep track of each one you have completed.
        // Basically if you find a spot where u depend on someone else, recursively dfs over there to know if it's  acceptable *///
        // if you can't 

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : prerequisites) {

            graph.computeIfAbsent(edge[0], k->new ArrayList()).add(edge[1]);

        }

        int[] state = new int[numCourses];

        for(int course =0; course < numCourses; course++){ 
            if(!dfs(graph, state, course)) return false;

        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int[] state, int course) {
        if(!graph.containsKey(course)) return true;
        if(state[course] == 1) return false;
        if(state[course] == 2) return true;
        state[course] = 1;
        for(Integer curr : graph.get(course)) {
            
            if(!dfs(graph, state, curr)) return false;

        }
        state[course] = 2;
        return true;
    }
}
