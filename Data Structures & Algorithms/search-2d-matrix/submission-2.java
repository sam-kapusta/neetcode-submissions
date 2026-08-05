class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // search a 2d array matrix and an integer target

        // increasing order

        // 1 2 4 8

        // First, search all the numbers in outside array. 


        // find row first
        int l = 0, r = matrix.length-1;
        int mid = -1;
        while (l <= r) { // If top == bot, it means you have found the right row
            mid = l + ((r-l) / 2);

            if(matrix[mid][0] == target) return true;

            else if(matrix[mid][0] < target && (mid == matrix.length-1 || target < matrix[mid+1][0])){
                break;
            } else if(matrix[mid][0] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // mid = the right row
        l = 0;
        r = matrix[0].length-1;
        int row = mid;
        while (l <= r) {
            mid = l + ((r-l)/2);
            if(matrix[row][mid] < target) {
                l = mid + 1;
            } else if(matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
