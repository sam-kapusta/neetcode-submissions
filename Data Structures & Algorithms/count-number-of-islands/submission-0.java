        // need a visited map so stuff doesnt get repeated. Basicall go as far deep as you can on each spot and see what you can find. If visited and a 1 immedietely return. If not it will go deeper and try to find something.

class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;


        boolean[][] visited = new boolean[rows][cols];

        int count = 0;
        for(int i=0; i < rows; i++) {
            for(int j=0; j < cols; j++) {
                count += dfs(grid, visited, i, j);

            }
        }

        return count;
    }

    private int dfs(char[][] grid, boolean[][] visited, int i, int j){
        
        if(i<0 || j < 0) return 0;
        if(i >= grid.length || j >= grid[0].length) return 0;
        if(visited[i][j]) return 0;

        if(grid[i][j] == '0'){
            visited[i][j] = true;
            return 0;
        } 
        
        visited[i][j] = true;
        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i, j-1);
        return 1;

    }
}
