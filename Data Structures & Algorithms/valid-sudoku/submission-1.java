class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int r=0; r < board.length; r++) {
            for(int c=0; c < board[0].length; c++) {
                Character curr = board[r][c];

                if (curr == '.') continue;

                String box = (r/3) + "," + (c/3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(curr) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(curr) ||
                    squares.computeIfAbsent(box, k -> new HashSet<>()).contains(curr)) {
                        return false;
                    }
                
                rows.get(r).add(curr);
                cols.get(c).add(curr);
                squares.get(box).add(curr);
            }
        }
        return true;
    }
}
