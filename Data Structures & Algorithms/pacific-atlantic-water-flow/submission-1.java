class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col]; 
        boolean[][] atlantic = new boolean[row][col]; 
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < row; i++) {
            dfs(heights, -1, i, 0, pacific);
            dfs(heights, -1, i, col-1, atlantic);
        }

        for(int j=0; j < col; j++) {
            dfs(heights, -1, 0, j, pacific);
            dfs(heights, -1, row-1, j, atlantic);
        }

        for(int i =0; i < row; i++) {
            for(int j=0; j < col; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    res.add(curr);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int prev, int i, int j, boolean[][] ocean) {
        if(i < 0 || j < 0) return;
        if(i >= heights.length || j >= heights[0].length) return;
        if(ocean[i][j]) return;

        if(prev <= heights[i][j]) {
            ocean[i][j] = true;
            dfs(heights, heights[i][j], i+1, j, ocean);
            dfs(heights, heights[i][j], i-1, j, ocean);
            dfs(heights, heights[i][j], i, j+1, ocean);
            dfs(heights, heights[i][j], i, j-1, ocean);
        }
        return;

    }
}
