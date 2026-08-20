class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        // dfs, need to not repeat areas i've already gone too
        // both pacific and atlantic have water. 


        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];

        for(int i = 0; i < heights.length; i++) {
            recurse(heights, pacific, 0, i, 0);
            recurse(heights, atlantic, 0, i, heights[0].length-1);
        }

        for(int j = 0; j < heights[0].length; j++) {
            recurse(heights, pacific, 0, 0, j);
            recurse(heights, atlantic, 0, heights.length-1, j);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i < heights.length; i++) {
            for(int j=0; j < heights[0].length; j++) {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void recurse(int[][] heights, int[][] ocean, int prev, int i, int j) {

        if(heights.length <= i || heights[0].length <= j || i < 0 || j < 0) return;
        if(ocean[i][j] != 0) return;
        if(heights[i][j] < prev) return;
        ocean[i][j] = 1;
        recurse(heights, ocean, heights[i][j], i+1, j);
        recurse(heights, ocean, heights[i][j], i-1, j);
        recurse(heights, ocean, heights[i][j], i, j+1);
        recurse(heights, ocean, heights[i][j], i, j-1);
    }
}
