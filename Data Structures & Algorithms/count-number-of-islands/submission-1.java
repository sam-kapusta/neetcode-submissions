        // need a visited map so stuff doesnt get repeated. Basicall go as far deep as you can on each spot and see what you can find. If visited and a 1 immedietely return. If not it will go deeper and try to find something.

class Solution {
    public int numIslands(char[][] grid) {
 
        // 1 is land 
        // 0 is water
        // return number of islands

        // can use dfs to go all directions from each point so a double for loop
        // need some way to find what's already been explored and just exit right away because it had already been explored

        int r = grid.length;
        int c = grid[0].length;
        int[][] seen = new int[r][c];
        int count = 0;
        for(int i=0; i < r; i++) {
            for(int j=0; j < c; j++) {
                count = count + dfs(grid, i, j, seen);
            }
        }
        return count;
    }

    private int dfs(char[][] grid, int i, int j, int[][] seen) {
        if(i >= grid.length || j >= grid[0].length) return 0;
        if(i == -1 || j == -1) return 0;
        if(seen[i][j] == 1) return 0;
        if(grid[i][j] == '0') return 0;

        seen[i][j] = 1;
        dfs(grid, i+1, j, seen);
        dfs(grid, i-1, j, seen);
        dfs(grid, i, j+1, seen);
        dfs(grid, i, j-1, seen);
        return 1;
    }
}
