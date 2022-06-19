class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> topRight = new HashSet<>();
        Set<Integer> bottomRight = new HashSet<>();
        
        List<StringBuffer> board = new ArrayList<>(n);
        
        for (int i = 0;i < n;i++) { 
            StringBuffer column = new StringBuffer();
            for (int j = 0;j < n;j++) {
                column.append(".");
            }
            board.add(column);
        }
        
        //System.out.println(board);
        
        List<List<String>> reVal = new ArrayList<>();
        
        
        solveNQueensHelper(0, rows, topRight, bottomRight, board, reVal);
        
        return reVal;
    }
    
    
    void solveNQueensHelper(int currentColumn, Set<Integer> rows, Set<Integer> topRight, Set<Integer> bottomRight, List<StringBuffer> board, List<List<String>> reVal) {
        // Stopping point
        if (currentColumn == board.size()) {
            List<String> goodBoard = new ArrayList<>();
            
            for (int i = 0;i < board.size();i++) {
                goodBoard.add(board.get(i).toString());
            }
            reVal.add(goodBoard);
            return;
        }
        
        StringBuffer column = board.get(currentColumn);
        //Iterate through the column
        
        for (int row = 0;row < column.length();row++) {
            // Check if another queen can attack at this location
            if (rows.contains(row) || topRight.contains(row - currentColumn) || bottomRight.contains(row + currentColumn)) {
                continue;
            }
            
            // Claim this location
            rows.add(row);
            topRight.add(row - currentColumn);
            bottomRight.add(row + currentColumn);
            
            column.replace(row, row + 1, "Q");
            //System.out.println(board);
            // Go a step deeper if we have a valid position
            solveNQueensHelper(currentColumn + 1, rows, topRight, bottomRight, board, reVal);
            
            column.replace(row, row + 1, ".");
            
                
            // Remove claim of location
            rows.remove(row);
            topRight.remove(row - currentColumn);
            bottomRight.remove(row + currentColumn);
            
        }
           
        
        return;
    }
}


/*


[
  [".Q.."
   "...Q"
   ".Q.."
   "..Q."
   
   
   
   ,["..Q.",
     "Q...","...Q",".Q.."]]


*/
