class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        if(ROWS == 0) return false;
        int COLS = matrix[0].length;
        if(COLS == 0) return false;

        int top = 0; int bot = ROWS - 1;
        int row = -1;

        while(top <= bot){
            int mid = top + (bot-top) / 2;
            if(matrix[mid][0] == target) return true;
            if(matrix[mid][0] < target) {
                row = mid;
                top = mid + 1;
            } else {
                bot = mid - 1;
            }
        }

        if(row == -1) return false;
        if(matrix[row][COLS-1] < target) return false;

        int l = 0; int r = COLS - 1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(matrix[row][mid] == target) return true;
            if(matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
